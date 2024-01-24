package com.ob.tsb.accounts.service.impl;


import com.ob.tsb.accounts.client.AccountsClient;
import com.ob.tsb.accounts.dto.consentDto.ConsentResponse;
import com.ob.tsb.accounts.enums.AccountType;
import com.ob.tsb.accounts.exception.CustomException;
import com.ob.tsb.accounts.exception.ResourceNotFoundException;
import com.ob.tsb.accounts.response.AccountsResponse;
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
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static com.ob.tsb.accounts.util.ApplicationConstants.CIRCUIT_BREAKER_FALLBACK_MSG;
import static java.rmi.server.LogStream.log;

@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger log = LogManager.getLogger(AccountServiceImpl.class);
    private final AuthServiceImpl authServiceImpl;

    private final WebClient webClient;

    private final AccountsClient accountsClient;

    @Value("${consent.url}")
    private String consentUrl;

    @Value("${consent.id}")
    private String consentId;

    @Value("${currentAccount.url}")
    private String currentAccountUrl;
    @Value("${accounts.url}")
    private String accountsUrl;//mock later is TSB
    @Value("${accountsById.url}")
    private String accountsByIdUrl;


    public AccountServiceImpl(AuthServiceImpl authServiceImpl, WebClient webClient, AccountsClient accountsClient) {
        this.authServiceImpl = authServiceImpl;
        this.webClient = webClient;
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


    @Override
    @CircuitBreaker(name = "accountService", fallbackMethod = "accountServiceCbFallback")
    public List<String> getAccountDetailsOfConsent(String consentId) {
        log.info("..getConsentDetails");
        List<String> accountList = new ArrayList<>();
        try {
            String status = getConsentStatus(authServiceImpl.getAccessToken(), consentId);
            if (status.equalsIgnoreCase("Authorized")) {
                ConsentResponse consentResponse = getConsentDetails(consentId);
                accountList = consentResponse.getData().getAccounts();

            } else {
                log.info("Not Authorized for this consent id");
            }
        } catch (Exception ex) {

        }
        return accountList;
    }

    @Override
    @CircuitBreaker(name = "accountService", fallbackMethod = "accountServiceCbFallback")
    public ConsentResponse getConsentDetails(String consentid) {
        log("--getConsentDetails---");
        AtomicReference<ConsentResponse> consentResponse = new AtomicReference<ConsentResponse>();
        try {
            UriComponentsBuilder componentsBuilder = UriComponentsBuilder
                    .fromHttpUrl(consentUrl)
                    .path(consentid);
            String url = componentsBuilder.toUriString();
            Mono<ConsentResponse> consentMono = webClient
                    .get()
                    .uri(componentsBuilder.toUriString())
                    .headers(headers -> headers.addAll(new HttpHeaders()))
                    .retrieve()
                    .onStatus(HttpStatusCode::isError,
                            response -> response.bodyToMono(String.class).flatMap(errorBody -> {
                                log.error("Error accounts status code {}, response body: {}", response.statusCode(), errorBody);
                                CustomException customException = new CustomException("451", "Failed to fetch accounts");
                                return Mono.error(customException);
                            }))
                    .bodyToMono(ConsentResponse.class)
                    .map(response -> {
                        log.info("response = {}", response.getData());
                        consentResponse.set(response);
                        return response;
                    });


            return consentResponse.get();
        } catch (Exception e) {
            log.error(" Error while reading accounts by id api mock response file");
            throw new ResourceNotFoundException(HttpStatus.NO_CONTENT, "mock response not found");
        }

    }

    @Override
    @CircuitBreaker(name = "accountService", fallbackMethod = "accountServiceCbFallback")
    public Mono<ResponseEntity<AccountsResponse>> getAccounts(String xFapiAuthDate, String xFapiCustomerIpAddress, String xFapiInteractionId, String accept) {
        log("In getAccounts");
        List<String> typeList = getAccountDetailsOfConsent(consentId);
        AccountsResponse accountResponse = new AccountsResponse();
        List<AccountsResponseDataAccountInner> accountList = new ArrayList<>();

        if (typeList.size() == 3) {

        } else {
            if (typeList.contains(AccountType.CurrentAccount.name())) {
                AccountsResponseDataAccountInner account = accountsClient.getCurrentAccountResponse(currentAccountUrl, new HttpHeaders());
                accountList.add(account);
            }

            /*if (typeList.contains(AccountType.CorporateCurrentAccount.name()))
                getCorporateCurrentAccount();
            if (typeList.contains(AccountType.CreditCardAccount.name()))
                getCreditCardAccount();*/
        }
        accountResponse.getData().setAccount(accountList);
        Mono<AccountsResponse> monoResponse = Mono.just(accountResponse);

        return monoResponse.map(e -> ResponseEntity.ok(e));

    }

    String getConsentStatus(String Token, String consentId) {

        //Hardik Method will be called
        return "Authorized";
    }


    public ResponseEntity accountServiceCbFallback(String token, RequestNotPermitted requestNotPermitted) {
        log.info("Account Service Fallback method called.");
        log.info("RequestNotPermitted exception message: {}", requestNotPermitted.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(CIRCUIT_BREAKER_FALLBACK_MSG);
    }


}
