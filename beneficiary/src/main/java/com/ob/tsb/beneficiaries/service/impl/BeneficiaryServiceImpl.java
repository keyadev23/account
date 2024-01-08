package com.ob.tsb.beneficiaries.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.ob.tsb.beneficiaries.model.response.beneficiary.BeneficiaryRespoonse;
import com.ob.tsb.beneficiaries.service.AuthService;
import com.ob.tsb.beneficiaries.service.BeneficiaryService;
import com.ob.tsb.beneficiaries.util.HeadersUtil;
import com.ob.tsb.beneficiaries.util.JsonUtil;
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
public class BeneficiaryServiceImpl implements BeneficiaryService {

    private static final Logger logger = LogManager.getLogger(BeneficiaryServiceImpl.class);
    private final AuthService authService;
    private final WebClient webClient;
    @Value("${api.fakeApi.uri}")
    private String gatewayUrl;
    @Value("${api.max-attempt}")
    private Integer maxAttempt;
    @Value("${api.delay-millis}")
    private Integer delayMillis;

    public BeneficiaryServiceImpl(AuthService authService, WebClient webClient) {
        this.authService = authService;
        this.webClient = webClient;
    }

    @Override
    public Mono<BeneficiaryRespoonse> getBeneficiariesById(String authDate,
                                                           String customerIpAddress,
                                                           String interactionId, String accept,
                                                           String accountId) {
        return authService
                .getToken()
                .flatMap(tokenResponse -> {
                    HttpHeaders httpHeaders = HeadersUtil.AuthHeader(tokenResponse.token());
                    httpHeaders.set("x-fapi-auth-date", authDate);
                    httpHeaders.set("x-fapi-customer-ip-address", customerIpAddress);
                    httpHeaders.set("x-fapi-interaction-id", interactionId);
                    httpHeaders.set("Accept", accept);
                    UriComponentsBuilder componentsBuilder = UriComponentsBuilder
                            .fromHttpUrl(gatewayUrl)
                            .path(accountId);

                    logger.info("Beneficiary Request: {} headers: {}",
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
                                        com.tsb.account.exception.CustomException customException = new com.tsb.account.exception.CustomException("451", "Failed to fetch accounts");
                                        return Mono.error(customException);
                                    }))
                            .bodyToMono(String.class)
                            .map(response -> {
                                logger.info("Beneficiary Response: {}", response);
                                return JsonUtil.toObject(response, BeneficiaryRespoonse.class);
                            })
                            .retryWhen(Retry.fixedDelay(maxAttempt, Duration.ofMillis(delayMillis)))
                            .onErrorResume(error -> {
                                logger.error("Error while fetching accounts max attempt done: {}", error.getMessage());
                                throw new com.tsb.account.exception.CustomException("451", "Failed to fetch accounts");
                            });
                });
    }
}
