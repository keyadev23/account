package com.ob.tsb.accounts.service.impl;

import com.ob.tsb.accounts.client.AccountClient;
import com.ob.tsb.accounts.client.ConsentClient;
import com.ob.tsb.accounts.dto.consentDto.ConsentResponse;
import com.ob.tsb.accounts.enums.AccountType;
import com.ob.tsb.accounts.exception.ResourceNotFoundException;
import com.ob.tsb.accounts.response.accountResponse.Account;
import com.ob.tsb.accounts.response.accountResponse.AccountResponse;
import com.ob.tsb.accounts.service.AccountConsentService;
import com.ob.tsb.accounts.util.JsonUtil;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

import static com.ob.tsb.accounts.exception.ErrorConstants.CONSENT_CLIENT_ERROR;
import static com.ob.tsb.accounts.exception.ErrorConstants.CONSENT_SERVER_ERROR;
import static com.ob.tsb.accounts.exception.ErrorDesc.handle4xxClientError;
import static com.ob.tsb.accounts.exception.ErrorDesc.handle5xxClientError;
import static com.ob.tsb.accounts.util.ApplicationConstants.CIRCUIT_BREAKER_FALLBACK_MSG;
import static java.rmi.server.LogStream.log;

@Service
@Slf4j
public class AccountConsentServiceImpl implements AccountConsentService {

    private final AuthServiceImpl authServiceImpl;

    private final WebClient webClient;

    private final AccountClient accountClient;

    @Value("${consent.url}")
    private String consentUrl;

    @Value("${consent.id}")
    private String consentId;

    @Value("${currentAccount.url}")
    private String currentAccountUrl;

    public AccountConsentServiceImpl(AuthServiceImpl authServiceImpl, ConsentClient consentClient, WebClient webClient, AccountClient accountClient) {
        this.authServiceImpl = authServiceImpl;
        this.webClient = webClient;
        this.accountClient = accountClient;
    }

    @Override
    @CircuitBreaker(name = "authService", fallbackMethod = "accountConsentServiceCbFallback")
    public ConsentResponse getConsentDetails(String consentid) {
        log("--getConsentDetails---");
        try{
            UriComponentsBuilder componentsBuilder = UriComponentsBuilder
                    .fromHttpUrl(consentUrl)
                    .path(consentid);
            return webClient.get()
                    .uri(componentsBuilder.toUriString())
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> {
                        return handle4xxClientError(CONSENT_CLIENT_ERROR, clientResponse);
                    })
                    .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> {
                        return handle5xxClientError(CONSENT_SERVER_ERROR, clientResponse);
                    })
                    .bodyToMono(String.class)
                    .map(str -> {
                        log("--getConsentDetails---");
                        return JsonUtil.toObject(str, ConsentResponse.class);
                    }).block();

        }catch (Exception e) {
            log.error(" Error while reading accounts by id api mock response file");
            throw new ResourceNotFoundException(HttpStatus.NO_CONTENT, "Mock response not found");
        }

    }

    @Override
    @CircuitBreaker(name = "authService", fallbackMethod = "accountConsentServiceCbFallback")
    public Mono<ResponseEntity<AccountResponse>> getAccounts(String xFapiAuthDate, String xFapiCustomerIpAddress, String xFapiInteractionId, String accept) {
        log("In getAccounts");
        List<String> typeList = getAccountDetailsOfConsent(consentId);
        AccountResponse accountResponse = new AccountResponse();
        List<Account> accountList = new ArrayList<>();

        if (typeList.size() == 3) {

        } else {
            if (typeList.contains(AccountType.CurrentAccount.name())) {
                Account account = accountClient.getCurrentAccountResponse(currentAccountUrl, new HttpHeaders());
                accountList.add(account);
            }

            /*if (typeList.contains(AccountType.CorporateCurrentAccount.name()))
                getCorporateCurrentAccount();
            if (typeList.contains(AccountType.CreditCardAccount.name()))
                getCreditCardAccount();*/
        }
        accountResponse.getMData().setMAccount(accountList);
        Mono<AccountResponse> monoResponse = Mono.just(accountResponse).subscribeOn(Schedulers.boundedElastic());

        return monoResponse.map(e -> ResponseEntity.ok(e));

    }

    @Override
    @CircuitBreaker(name = "authService", fallbackMethod = "accountConsentServiceCbFallback")
    public List<String> getAccountDetailsOfConsent(String consentId) {
        AccountConsentServiceImpl.log.info("..getConsentDetails");
        List<String> accountList = new ArrayList<>();
        try {
            String status = getConsentStatus(authServiceImpl.getAccessToken(), consentId);
            if (status.equalsIgnoreCase("Authorized")) {
                ConsentResponse consentResponse = getConsentDetails(consentId);
                accountList = consentResponse.getData().getAccounts();

            } else {
                AccountConsentServiceImpl.log.info("Not Authorized for this consent id");
            }
        } catch (Exception ex) {

        }
        return accountList;
    }

    String getConsentStatus(String Token, String consentId) {

        //Hardik Method will be called
        return "Authorized";
    }

    public ResponseEntity accountConsentServiceCbFallback(String token, RequestNotPermitted requestNotPermitted) {
        AccountConsentServiceImpl.log.info("Account Service Fallback method called.");
        AccountConsentServiceImpl.log.info("RequestNotPermitted exception message: {}", requestNotPermitted.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(CIRCUIT_BREAKER_FALLBACK_MSG);
    }


}
