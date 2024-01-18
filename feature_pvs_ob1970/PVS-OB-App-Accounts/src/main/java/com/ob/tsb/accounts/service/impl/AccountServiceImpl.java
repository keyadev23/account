package com.ob.tsb.accounts.service.impl;


import com.ob.tsb.accounts.client.AccountsClient;
import com.ob.tsb.accounts.dto.consentDto.ConsentResponse;
import com.ob.tsb.accounts.dto.corporateCurrentAccountDto.CorporateCurrentAccountResponse;
import com.ob.tsb.accounts.dto.creditCardAccountDto.CreditCardAccountResponse;
import com.ob.tsb.accounts.dto.currentAccountDto.CurrentAccountResponse;
import com.ob.tsb.accounts.enums.AccountType;
import com.ob.tsb.accounts.response.AccountsResponse;
import com.ob.tsb.accounts.service.AccountService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import reactor.core.publisher.Mono;

import java.util.List;

import static com.ob.tsb.accounts.util.ApplicationConstants.CIRCUIT_BREAKER_FALLBACK_MSG;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Value("${accounts.url}")
    private String accountsUrl;//mock later is TSB

    @Value("${accountsById.url}")
    private String accountsByIdUrl;

    private final AccountsClient accountsClient;
    private final AccountConsentServiceImpl accountConsentService;

    public AccountServiceImpl(String accountsUrl, AccountsClient accountsClient, AccountConsentServiceImpl accountConsentService) {
        this.accountsClient = accountsClient;
        this.accountConsentService = accountConsentService;
    }


    /*@Override
    @CircuitBreaker(name = "accountService", fallbackMethod = "accountServiceCbFallback")
    public Mono<ResponseEntity<AccountsResponse>> getAccounts() {
          return accountsClient.processAccountApiRequest(accountsUrl, HttpMethod.GET, new HttpHeaders(), new LinkedMultiValueMap()); //request body
    }*/

    @Override
    @CircuitBreaker(name = "accountService", fallbackMethod = "accountServiceCbFallback")
    public Mono<ResponseEntity<AccountsResponse>> getAccounts(String xFapiAuthDate, String xFapiCustomerIpAddress, String xFapiInteractionId, String accept) {
        List<String> accountList =accountConsentService.getAccountDetails("");
        if(accountList.size()==3) {
            getCurrentAccount();
            getCorporateCurrentAccount();
            getCreditCardAccount();
        }
        else
        if(accountList.contains(AccountType.CurrentAccount.name()))
            getCurrentAccount();
        if(accountList.contains(AccountType.CorporateCurrentAccount.name()))
            getCorporateCurrentAccount();
        if(accountList.contains(AccountType.CreditCardAccount.name()))
            getCreditCardAccount();
        return null;
    }

    @Override
    @CircuitBreaker(name = "accountService", fallbackMethod = "accountServiceCbFallback")
    public Mono<ResponseEntity<AccountsResponse>> getAccountById(String accountId) {
        return accountsClient.processAccountApiRequest(accountsUrl+"/"+accountId, HttpMethod.GET, new HttpHeaders(), new LinkedMultiValueMap());
     }

    @Override
    public CurrentAccountResponse getCurrentAccount() {
        return null;
    }

    @Override
    public CorporateCurrentAccountResponse getCorporateCurrentAccount() {
        return null;
    }

    @Override
    public CreditCardAccountResponse getCreditCardAccount() {
        return null;
    }


    public ResponseEntity accountServiceCbFallback(String token, RequestNotPermitted requestNotPermitted) {
        log.info("Account Service Fallback method called.");
        log.info("RequestNotPermitted exception message: {}", requestNotPermitted.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(CIRCUIT_BREAKER_FALLBACK_MSG);
    }



}
