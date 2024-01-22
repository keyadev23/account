package com.ob.tsb.accounts.service.impl;


import com.ob.tsb.accounts.client.AccountClient;
import com.ob.tsb.accounts.client.AccountsClient;
import com.ob.tsb.accounts.response.AccountsResponse;
import com.ob.tsb.accounts.service.AccountService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import reactor.core.publisher.Mono;

import static com.ob.tsb.accounts.util.ApplicationConstants.CIRCUIT_BREAKER_FALLBACK_MSG;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final AccountsClient accountsClient;
    @Value("${accounts.url}")
    private String accountsUrl;//mock later is TSB
    @Value("${accountsById.url}")
    private String accountsByIdUrl;


    public AccountServiceImpl(AccountsClient accountsClient) {
        this.accountsClient = accountsClient;

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


    public ResponseEntity accountServiceCbFallback(String token, RequestNotPermitted requestNotPermitted) {
        log.info("Account Service Fallback method called.");
        log.info("RequestNotPermitted exception message: {}", requestNotPermitted.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(CIRCUIT_BREAKER_FALLBACK_MSG);
    }


}
