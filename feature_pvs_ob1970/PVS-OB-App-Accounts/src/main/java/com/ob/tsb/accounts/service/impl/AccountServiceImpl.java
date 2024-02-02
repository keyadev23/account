package com.ob.tsb.accounts.service.impl;


import com.ob.tsb.accounts.client.AccountsClient;
import com.ob.tsb.accounts.dto.consentDto.ConsentResponse;
import com.ob.tsb.accounts.enums.AccountSubType;
import com.ob.tsb.accounts.exception.ResourceNotFoundException;
import com.ob.tsb.accounts.exception.UnauthorizedException;
import com.ob.tsb.accounts.response.AccountsResponse;
import com.ob.tsb.accounts.response.AccountsResponseData;
import com.ob.tsb.accounts.response.AccountsResponseDataAccountInner;
import com.ob.tsb.accounts.service.AccountService;
import com.ob.tsb.accounts.util.ConsentStatus;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.ob.tsb.accounts.util.ApplicationConstants.CIRCUIT_BREAKER_FALLBACK_MSG;

@Service
@Slf4j
@Data
public class AccountServiceImpl implements AccountService {

    private final AccountsClient accountsClient;
    @Value("${accounts.url}")
    private String accountsUrl;//mock later is TSB
    @Value("${accountsById.url}")
    private String accountsByIdUrl;
    @Value("${consent.url}")
    private String consentUrl;
    @Value("${currentAccount.url}")
    private String currentAccountUrl;
    @Value("${corporateCurrentAccount.url}")
    private String corporateCurrentAccountUrl;
    @Value("${creditCardAccount.url}")
    private String creditCardAccountUrl;
    @Value("${consent.id}")
    private String consentId;


    public AccountServiceImpl(AccountsClient accountsClient) {
        this.accountsClient = accountsClient;
    }

    @Override
    @CircuitBreaker(name = "accountService", fallbackMethod = "accountServiceCbFallback")
    public Mono<ResponseEntity<AccountsResponse>> getAccounts(String authorization) {
        log.info("In getAccounts");
        List<String> typeList = new ArrayList<>();
        ConsentStatus status = getConsentStatus(authorization);
        status = ConsentStatus.AUTHORISED;
        if (status.equals(ConsentStatus.AUTHORISED)) {
            ConsentResponse consent = getConsents(consentId);

            typeList.addAll(consent.getData().getAccounts());

            //return accountsClient.processAccountApiRequest(accountsUrl, HttpMethod.GET, new HttpHeaders(), new LinkedMultiValueMap()); //request body
        } else {
            throw new UnauthorizedException(HttpStatus.UNAUTHORIZED, " Authorization Failed");
        }

        AccountsResponse accountResponse = new AccountsResponse();
        List<AccountsResponseDataAccountInner> accountList = new ArrayList<>();


        if (typeList.contains(AccountSubType.CurrentAccount.name())) {
            AccountsResponseDataAccountInner account = accountsClient.getCurrentAccountResponse(currentAccountUrl);
            accountList.add(account);
        }

        if (typeList.contains(AccountSubType.CorporateCurrentAccount.name())) {
            AccountsResponseDataAccountInner account = accountsClient.getCorporateCurrentAccountResponse(corporateCurrentAccountUrl, new HttpHeaders());
            accountList.add(account);
        }

        if (typeList.contains(AccountSubType.CreditCardAccount.name())) {
            AccountsResponseDataAccountInner account = accountsClient.getCreditCardAccountResponse(creditCardAccountUrl, new HttpHeaders());
            accountList.add(account);
        }


        AccountsResponseData data = new AccountsResponseData();
        data.setAccount(accountList);
        accountResponse.setData(data);
        Mono<AccountsResponse> monoResponse = Mono.just(accountResponse);
        return monoResponse.map(e -> ResponseEntity.ok(e));
    }


    @Override
    @CircuitBreaker(name = "accountService", fallbackMethod = "accountServiceCbFallback")
    public Mono<ResponseEntity<AccountsResponse>> getAccountById(String authorization, String accountId) {
        log.info("In getAccounts");
        List<String> typeList = new ArrayList<>();
        ConsentStatus status = getConsentStatus(authorization);
        status = ConsentStatus.AUTHORISED;
        if (status.equals(ConsentStatus.AUTHORISED)) {
            ConsentResponse consent = getConsents(consentId);
            typeList.addAll(consent.getData().getAccounts());
        } else {
            throw new UnauthorizedException(HttpStatus.UNAUTHORIZED, " Authorization Failed");
        }

        AccountsResponse accountResponse = new AccountsResponse();
        List<AccountsResponseDataAccountInner> accountList = new ArrayList<>();


        if (typeList.contains(AccountSubType.CurrentAccount.name())) {
            AccountsResponseDataAccountInner account = accountsClient.getCurrentAccountResponse(currentAccountUrl);
            if (accountId.equals(account.getAccountId()))
                accountList.add(account);
        }

        if (typeList.contains(AccountSubType.CorporateCurrentAccount.name())) {
            AccountsResponseDataAccountInner account = accountsClient.getCorporateCurrentAccountResponse(corporateCurrentAccountUrl, new HttpHeaders());
            if (accountId.equals(account.getAccountId()))
                accountList.add(account);
        }

        if (typeList.contains(AccountSubType.CreditCardAccount.name())) {
            AccountsResponseDataAccountInner account = accountsClient.getCreditCardAccountResponse(creditCardAccountUrl, new HttpHeaders());
            if (accountId.equals(account.getAccountId()))
                accountList.add(account);
        }


        AccountsResponseData data = new AccountsResponseData();
        data.setAccount(accountList);
        accountResponse.setData(data);
        Mono<AccountsResponse> monoResponse = Mono.just(accountResponse);
        return monoResponse.map(e -> ResponseEntity.ok(e));

    }

    public ResponseEntity accountServiceCbFallback(String token, RequestNotPermitted requestNotPermitted) {
        log.info("Account Service Fallback method called.");
        log.info("RequestNotPermitted exception message: {}", requestNotPermitted.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(CIRCUIT_BREAKER_FALLBACK_MSG);
    }

    @Override
    @CircuitBreaker(name = "accountService", fallbackMethod = "accountServiceCbFallback")
    public ConsentResponse getConsents(String consentId) {
        try {
            UriComponentsBuilder componentsBuilder = UriComponentsBuilder
                    .fromHttpUrl(consentUrl)
                    .path(consentId);
            RestTemplate restTemplate = new RestTemplate();
            ConsentResponse consent = restTemplate.getForObject(componentsBuilder.toUriString(), ConsentResponse.class);

            return consent;
        } catch (Exception e) {
            log.error(" Error while reading accounts by id api mock response file");
            throw new ResourceNotFoundException(HttpStatus.NO_CONTENT, "mock response not found");
        }
    }


    public ConsentStatus getConsentStatus(String token) {

        Random random = new Random();
        int number = random.nextInt(3) + 1;
        return switch (number) {
            case 1 -> ConsentStatus.AWAITING_AUTHORISATION;
            case 2 -> ConsentStatus.AUTHORISED;
            case 3 -> ConsentStatus.REJECTED;
            default -> ConsentStatus.AWAITING_AUTHORISATION;
        };
    }


}
