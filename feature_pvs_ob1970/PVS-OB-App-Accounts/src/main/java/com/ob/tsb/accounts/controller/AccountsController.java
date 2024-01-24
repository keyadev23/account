package com.ob.tsb.accounts.controller;

import com.ob.tsb.accounts.api.AccountsApi;
import com.ob.tsb.accounts.exception.CustomException;
import com.ob.tsb.accounts.response.AccountsResponse;
import com.ob.tsb.accounts.service.AccountService;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import static com.ob.tsb.accounts.util.ApplicationConstants.BULK_HEAD_FALLBACK_MSG;
import static com.ob.tsb.accounts.util.ApplicationConstants.RATE_LIMIT_FALLBACK_MSG;

@RestController
@Slf4j
public class AccountsController implements AccountsApi {

    // private final RateLimiterRegistry registry;

    private final AccountService accountService;

    public AccountsController(AccountService accountService) { //RateLimiterRegistry registry,
        //  this.registry = registry;
        this.accountService = accountService;
    }


    @Override
    @RateLimiter(name = "accountRateLimit", fallbackMethod = "rateLimitFallbackMethod")
    @Bulkhead(name = "accountBulkheadInstance", fallbackMethod = "bulkheadFallback")
    public Mono<ResponseEntity<String>> healthCheck(ServerWebExchange exchange) {
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body("Health is good"));
    }


    @ExceptionHandler(CustomException.class)
    @Override
    @RateLimiter(name = "accountRateLimit", fallbackMethod = "rateLimitFallbackMethod")
    @Bulkhead(name = "accountBulkheadInstance", fallbackMethod = "bulkheadFallback")
    public Mono<ResponseEntity<AccountsResponse>> accounts(@RequestHeader("x-fapi-auth-date") String xFapiAuthDate,
                                                          @RequestHeader("x-fapi-customer-ip-address") String xFapiCustomerIpAddress,
                                                          @RequestHeader("x-fapi-interaction-id") String xFapiInteractionId,
                                                          @RequestHeader("Accept") String accept, ServerWebExchange exchange) {
        return accountService.getAccounts(xFapiAuthDate, xFapiCustomerIpAddress, xFapiInteractionId, accept);
    }

    @Override
    @RateLimiter(name = "accountRateLimit", fallbackMethod = "rateLimitFallbackMethod")
    @Bulkhead(name = "accountBulkheadInstance", fallbackMethod = "bulkheadFallback")
    public Mono<ResponseEntity<AccountsResponse>> accountsById(String accountId, String authorization, String xFapiAuthDate, String xFapiCustomerIpAddress, String xFapiInteractionId, String accept, ServerWebExchange exchange) {
        return accountService.getAccountById(accountId);
    }

    public ResponseEntity rateLimitFallbackMethod(String token, RequestNotPermitted requestNotPermitted) {
        log.info("Auth Service Fallback method called.");
        log.info("RequestNotPermitted exception message: {}", requestNotPermitted.getMessage());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Retry-After", "60s");

        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                .headers(responseHeaders)
                .body(RATE_LIMIT_FALLBACK_MSG);
    }

    public ResponseEntity bulkheadFallback(String token, RequestNotPermitted requestNotPermitted) {
        log.info("Bulkhead applied no further calls are accepted");
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                .body(BULK_HEAD_FALLBACK_MSG);
    }

    /*@PostConstruct
    public void postConstruct() {
        io.github.resilience4j.ratelimiter.RateLimiter.EventPublisher eventPublisher = registry
                .rateLimiter("authRateLimiterEvents")
                .getEventPublisher();
        eventPublisher.onEvent(event -> System.out.println("Auth Rate Limit - On Event. Event Details: " + event));
        eventPublisher.onSuccess(event -> System.out.println("Auth Rate Limit - On Success. Event Details: " + event));
        eventPublisher.onFailure(event -> System.out.println("Auth Rate Limit - On Failure. Event Details: " + event));
    }*/

}
