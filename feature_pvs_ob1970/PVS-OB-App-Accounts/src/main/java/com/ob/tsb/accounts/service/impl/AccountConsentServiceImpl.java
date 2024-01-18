package com.ob.tsb.accounts.service.impl;

import com.ob.tsb.accounts.client.ConsentClient;
import com.ob.tsb.accounts.dto.consentDto.ConsentResponse;
import com.ob.tsb.accounts.enums.AccountType;
import com.ob.tsb.accounts.response.AccountsResponse;
import com.ob.tsb.accounts.service.AccountConsentService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static com.ob.tsb.accounts.exception.ErrorConstants.CONSENT_CLIENT_ERROR;
import static com.ob.tsb.accounts.exception.ErrorConstants.CONSENT_SERVER_ERROR;
import static com.ob.tsb.accounts.exception.ErrorDesc.handle4xxClientError;
import static com.ob.tsb.accounts.exception.ErrorDesc.handle5xxClientError;
import static com.ob.tsb.accounts.util.ApplicationConstants.CIRCUIT_BREAKER_FALLBACK_MSG;

@Component
@Slf4j
public class AccountConsentServiceImpl implements AccountConsentService {

    private final AuthServiceImpl authServiceImpl;

    private final WebClient webClient;

    @Value("${consent.url}")
    private String consentUrl;

    public AccountConsentServiceImpl(AuthServiceImpl authServiceImpl, ConsentClient consentClient, WebClient webClient) {
        this.authServiceImpl = authServiceImpl;
        this.webClient = webClient;
    }

    @Override
    public ConsentResponse getConsentDetails(String consentId){
        ConsentResponse consent = webClient.post().uri(consentUrl+consentId).retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> { return handle4xxClientError(CONSENT_CLIENT_ERROR, clientResponse);})
                .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> { return handle5xxClientError(CONSENT_SERVER_ERROR, clientResponse);})
                .bodyToMono(ConsentResponse.class).block();
        return consent;

    }

    @Override
    public  List<String> getAccountDetails(String consentId) {
        log.info("..getConsentDetails");
        List<String> accountList = new ArrayList<>();
        try{
            String status = getConsentStatus(authServiceImpl.getAccessToken(), consentId);
            if (status.equalsIgnoreCase("Authorized")) {
                ConsentResponse consentResponse = getConsentDetails(consentId);
                accountList = consentResponse.getData().getAccounts();

            } else {
                log.info("Not Authorized for this consent id");
            }
        }catch(Exception ex){

        }
        return accountList;
    }

    String getConsentStatus(String Token, String consentId){

        //Hardik Method will be called
        return "Authorized";
    }

    public ResponseEntity accountConsentServiceCbFallback(String token, RequestNotPermitted requestNotPermitted) {
        log.info("Account Service Fallback method called.");
        log.info("RequestNotPermitted exception message: {}", requestNotPermitted.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(CIRCUIT_BREAKER_FALLBACK_MSG);
    }
}
