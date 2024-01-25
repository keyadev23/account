package com.ob.tsb.accounts.config;


import com.ob.tsb.accounts.service.AuthService;
import com.ob.tsb.accounts.service.ConsentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import static com.ob.tsb.accounts.util.ApplicationConstants.ACCESS_FORBIDDEN;


@Component
@Order(1)
public class AccountsApiFilter implements WebFilter {
    private static final String SWAGGER_UI_PATH = "/swagger-ui";
    private static final String SWAGGER_RESOURCES_PATH = "/webjars/";
    private static final String SWAGGER_DOC = "api-docs";
    @Autowired
    AuthService authService;
    @Autowired
    ConsentService consentService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String path = exchange.getRequest().getPath().toString();
        if (path.contains(SWAGGER_DOC) || path.contains(SWAGGER_UI_PATH) || path.contains(SWAGGER_RESOURCES_PATH)) {
            return chain.filter(exchange);
        }
        HttpHeaders httpHeaders = exchange.getRequest().getHeaders();
        MultiValueMap params = exchange.getRequest().getQueryParams();
        String token = httpHeaders.getFirst(HttpHeaders.AUTHORIZATION);
        token = "test_token";

        if (token == null || !authService.validateToken(token)) { // || !consentService.validateConsents(List.of(), token)
            HttpEntity<String> httpEntity = new HttpEntity<>(ACCESS_FORBIDDEN);
            exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
            exchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);
            return exchange.getResponse().writeWith(Mono.just(exchange.getResponse().bufferFactory().wrap(httpEntity.getBody().getBytes())));
        }
        return chain.filter(exchange);
    }
}
