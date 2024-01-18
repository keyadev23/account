package com.ob.tsb.accounts.client;

import com.ob.tsb.accounts.dto.consentDto.ConsentResponse;
import com.ob.tsb.accounts.model.Auth;
import com.ob.tsb.accounts.model.Consent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

import static com.ob.tsb.accounts.exception.ErrorConstants.*;
import static com.ob.tsb.accounts.exception.ErrorDesc.handle4xxClientError;
import static com.ob.tsb.accounts.exception.ErrorDesc.handle5xxClientError;

@Component
public class ConsentClient {
    private final WebClient webClient;

    @Value("${consent.url}")
    private String consentUrl;


    public ConsentClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public boolean validateConsent(List<String> consents, String token){
        Consent consent = webClient.post().uri(consentUrl+token).retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> { return handle4xxClientError(CONSENT_CLIENT_ERROR, clientResponse);})
                .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> { return handle5xxClientError(CONSENT_SERVER_ERROR, clientResponse);})
                .bodyToMono(Consent.class).block();
        return consent.isValid();
    }

}
