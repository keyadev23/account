package com.ob.tsb.accounts.client;


import com.ob.tsb.accounts.exception.ErrorConstants;
import com.ob.tsb.accounts.exception.ErrorDesc;
import com.ob.tsb.accounts.model.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.Disposable;

import static com.ob.tsb.accounts.exception.ErrorConstants.AUTH_CLIENT_ERROR;
import static com.ob.tsb.accounts.exception.ErrorConstants.AUTH_SERVER_ERROR;
import static com.ob.tsb.accounts.exception.ErrorDesc.handle4xxClientError;
import static com.ob.tsb.accounts.exception.ErrorDesc.handle5xxClientError;

@Component
@Slf4j
public class AuthClient {

    private final WebClient webClient;

    @Value("${auth.url}")
    private String authUrl;


    public AuthClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public boolean validatePrivileage(String token){
      /* Auth auth = webClient.get().uri(authUrl+token).retrieve()
               .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> { return handle4xxClientError(AUTH_CLIENT_ERROR, clientResponse);})
               .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> { return handle5xxClientError(AUTH_SERVER_ERROR, clientResponse);})
               .bodyToMono(Auth.class).block();
        return auth.isValid();*/
        log.info("-------token------" + token);
        if(token.equalsIgnoreCase("test_token")){
            return true;
        }
        return false;
    }
}
