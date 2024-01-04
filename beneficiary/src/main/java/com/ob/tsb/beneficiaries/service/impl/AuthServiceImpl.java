package com.ob.tsb.beneficiaries.service.impl;


import com.ob.tsb.beneficiaries.service.AuthService;
import com.tsb.account.model.response.token.TokenResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuthServiceImpl implements AuthService {


    @Value("${api.token.uri}")
    private String tokenUrl;

    @Value("${api.max-attempt}")
    private Integer maxAttempt;
    @Value("${api.delay-millis}")
    private Integer delayMillis;

    @Override
    public Mono<TokenResponse> getToken() {
        TokenResponse token = new TokenResponse("Az90SAOJklae", "bearer");

        return Mono.justOrEmpty(token);
    }

  /*  @Override
    public Mono<TokenResponse> getToken() {

        HttpHeaders httpHeaders = HeadersUtil.defaultHeader();
        TokenRequest tokenRequest = PayloadUtil.tokenRequest();
        log.info("Token Request: {}",tokenRequest);
        return webClient.post()
                .uri(tokenUrl)
                .headers(head -> head.addAll(httpHeaders))
                .bodyValue(tokenRequest)
                .retrieve()
                .onStatus(HttpStatusCode::isError,
                        response -> response.bodyToMono(String.class).flatMap(errorBody -> {
                            log.error("Error token status code {}, response body: {}",response.statusCode(), errorBody);
                            CustomException customException = new CustomException("451","Failed to fetch Token");
                            return Mono.error(customException);
                        }))
                .bodyToMono(String.class)
                .map(response -> {
                    log.info("Token Response: {}",response);
                    return JsonUtil.toObject(response, TokenResponse.class);
                })
                .retryWhen(Retry.fixedDelay(maxAttempt, Duration.ofMillis(delayMillis)))
                .onErrorResume(error -> {
                    log.error("Error while fetching user information max attempt done: {}", error.getMessage());
                    throw new CustomException("451","Failed to fetch Token");
                });
    }*/
}
