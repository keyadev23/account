package com.ob.tsb.accounts.service.impl;


import com.ob.tsb.accounts.client.AccountsClient;
import com.ob.tsb.accounts.client.ConsentClient;
import com.ob.tsb.accounts.dto.consentDto.ConsentResponse;
import com.ob.tsb.accounts.enums.AccountSubType;
import com.ob.tsb.accounts.exception.ResourceNotFoundException;
import com.ob.tsb.accounts.response.AccountsResponse;
import com.ob.tsb.accounts.response.AccountsResponseData;
import com.ob.tsb.accounts.response.AccountsResponseDataAccountInner;
import com.ob.tsb.accounts.service.AccountService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static com.ob.tsb.accounts.util.ApplicationConstants.CIRCUIT_BREAKER_FALLBACK_MSG;


@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger log = LogManager.getLogger(AccountServiceImpl.class);
    private final AuthServiceImpl authServiceImpl;

    private final WebClient webClient;

    private final AccountsClient accountsClient;

    private final ConsentClient consentClient;

    @Value("${consent.url}")
    private String consentUrl;

    @Value("${consent.id}")
    private String consentId;

    @Value("${currentAccount.url}")
    private String currentAccountUrl;

    @Value("${corporateCurrentAccount.url}")
    private String corporateCurrentAccountUrl;

    @Value("${creditCardAccount.url}")
    private String creditCardAccountUrl;

    @Value("${accounts.url}")
    private String accountsUrl;//mock later is TSB
    @Value("${accountsById.url}")
    private String accountsByIdUrl;

    private AtomicReference<ConsentResponse> consentResponse = new AtomicReference<ConsentResponse>();


    public AccountServiceImpl(AuthServiceImpl authServiceImpl, WebClient webClient, AccountsClient accountsClient, ConsentClient consentClient) {
        this.authServiceImpl = authServiceImpl;
        this.webClient = webClient;
        this.accountsClient = accountsClient;
        this.consentClient = consentClient;
    }


    @Override
    @CircuitBreaker(name = "accountService", fallbackMethod = "accountServiceCbFallback")
    public Mono<ResponseEntity<AccountsResponse>> getAccounts() {
        return accountsClient.processAccountApiRequest(accountsUrl, HttpMethod.GET, new HttpHeaders(), new LinkedMultiValueMap()); //request body
    }

    @Override
    @CircuitBreaker(name = "accountService", fallbackMethod = "accountServiceCbFallback")
    public Mono<ResponseEntity<AccountsResponse>> getAccountById(String accountId) {
        return accountsClient.processAccountApiRequest(accountsUrl + "/" + accountId, HttpMethod.GET, new HttpHeaders(), new LinkedMultiValueMap());
    }

    private String getConsentStatus(String accessToken, String consentId) {
        //Hardik Method will be called
        return "Authorized";
    }

    @Override
    @CircuitBreaker(name = "accountService", fallbackMethod = "accountServiceCbFallback")
    public Mono<ResponseEntity<AccountsResponse>> getAccounts(String xFapiAuthDate, String xFapiCustomerIpAddress, String xFapiInteractionId, String accept) {
        log.info("In getAccounts");
           String status = getConsentStatus(authServiceImpl.getAccessToken(), consentId);
        List<String> typeList = new ArrayList<>();
            if (status.equalsIgnoreCase("Authorized")) {
                ConsentResponse consent = getConsents(consentId);

                typeList.addAll(consent.getData().getAccounts());

            } else {
                log.info("Not Authorized for this consent id");
            }
                AccountsResponse accountResponse = new AccountsResponse();
                List<AccountsResponseDataAccountInner> accountList = new ArrayList<>();

                if (typeList.contains(AccountSubType.CurrentAccount.name())) {
                    AccountsResponseDataAccountInner account = accountsClient.getCurrentAccountResponse(currentAccountUrl);
                    accountList.add(account);
                }

                if (typeList.contains(AccountSubType.CorporateCurrentAccount.name())){
                   AccountsResponseDataAccountInner account = accountsClient.getCorporateCurrentAccountResponse(corporateCurrentAccountUrl, new HttpHeaders());
                   accountList.add(account);
                }

                if (typeList.contains(AccountSubType.CreditCardAccount.name())){
                    AccountsResponseDataAccountInner account = accountsClient.getCreditCardAccountResponse(creditCardAccountUrl, new HttpHeaders());
                    accountList.add(account);
                }


            AccountsResponseData data = new AccountsResponseData();
            data.setAccount(accountList);
            accountResponse.setData(data);
            Mono<AccountsResponse> monoResponse= Mono.just(accountResponse);
            return monoResponse.map(e -> ResponseEntity.ok(e));
    }

    @Override
    @CircuitBreaker(name = "accountService", fallbackMethod = "accountServiceCbFallback")
    public ConsentResponse getConsents(String consentId) {
        try{
            UriComponentsBuilder componentsBuilder = UriComponentsBuilder
                    .fromHttpUrl(consentUrl)
                    .path(consentId);
            RestTemplate restTemplate = new RestTemplate();
            ConsentResponse consent = restTemplate.getForObject(componentsBuilder.toUriString(),ConsentResponse.class);

            return consent;
        } catch (Exception e) {
            log.error(" Error while reading accounts by id api mock response file");
            throw new ResourceNotFoundException(HttpStatus.NO_CONTENT, "mock response not found");
        }
    }


    public ResponseEntity accountServiceCbFallback(String token, RequestNotPermitted requestNotPermitted) {
        log.info("Account Service Fallback method called.");
        log.info("RequestNotPermitted exception message: {}", requestNotPermitted.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(CIRCUIT_BREAKER_FALLBACK_MSG);
    }


}
