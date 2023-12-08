package com.tsb.account.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;

import com.tsb.account.exception.CustomException;
import com.tsb.account.model.response.account.AccountResponse;
import com.tsb.account.service.AccountService;
import com.tsb.account.service.AuthService;
import com.tsb.account.util.HeadersUtil;
import com.tsb.account.util.JsonUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    private static final Logger logger = LogManager.getLogger(AccountServiceImpl.class);
    @Value("${api.fakeApi.uri}")
    private String gatewayUrl;

    @Value("${api.max-attempt}")
    private Integer maxAttempt;
    @Value("${api.delay-millis}")
    private Integer delayMillis;

    private final AuthService authService;
    private final WebClient webClient;

    public AccountServiceImpl(AuthService authService, WebClient webClient) {
        this.authService = authService;
        this.webClient = webClient;
    }


    @Override
    public Flux<AccountResponse> getAccounts(
            String authDate,
            String customerIpAddress,
            String interactionId,
            String accept) {

        return authService
                .getToken()
                .flatMap(tokenResponse -> {
                    HttpHeaders httpHeaders = HeadersUtil.AuthHeader(tokenResponse.token());
                    httpHeaders.set("x-fapi-auth-date", authDate);
                    httpHeaders.set("x-fapi-customer-ip-address", customerIpAddress);
                    httpHeaders.set("x-fapi-interaction-id", interactionId);
                    httpHeaders.set("Accept", accept);
                    UriComponentsBuilder componentsBuilder = UriComponentsBuilder
                            .fromHttpUrl(gatewayUrl);

                    logger.info("Accounts Request: {} headers: {}",
                            componentsBuilder.toUriString(),
                            JsonUtil.toJson(httpHeaders));
                    return webClient
                            .get()
                            .uri(componentsBuilder.toUriString())
                            .headers(head -> head.addAll(httpHeaders))
                            .retrieve()
                            .onStatus(HttpStatusCode::isError,
                                    response -> response.bodyToMono(String.class).flatMap(errorBody -> {
                                        logger.error("Error accounts status code {}, response body: {}", response.statusCode(), errorBody);
                                        CustomException customException = new CustomException("451", "Failed to fetch accounts");
                                        return Mono.error(customException);
                                    }))
                            .bodyToMono(String.class)
                            .map(response -> {
                                logger.info("Accounts Response: {}", response);
                                return JsonUtil.toObjectOfList(response, new TypeReference<List<AccountResponse>>() {
                                });
                            })
                            .retryWhen(Retry.fixedDelay(maxAttempt, Duration.ofMillis(delayMillis)))
                            .onErrorResume(error -> {
                                logger.error("Error while fetching accounts max attempt done: {}", error.getMessage());
                                throw new CustomException("451", "Failed to fetch accounts");
                            });
                }).flatMapMany(Flux::fromIterable)
                .log();


    }
}
