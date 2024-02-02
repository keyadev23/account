package com.ob.tsb.accounts.service.impl;

import com.ob.tsb.accounts.client.AuthClient;
import com.ob.tsb.accounts.service.AuthService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static com.ob.tsb.accounts.util.ApplicationConstants.CIRCUIT_BREAKER_FALLBACK_MSG;


@Service
@Slf4j
public class AuthServiceImpl implements AuthService {


    private final AuthClient authClient;

    public AuthServiceImpl(AuthClient authClient) {
        this.authClient = authClient;
    }

    @Override
    @CircuitBreaker(name = "authService", fallbackMethod = "authServiceCbFallback")
    public boolean validateToken(String token) {
        return authClient.validatePrivileage(token);
    }

    public ResponseEntity authServiceCbFallback(String token, RequestNotPermitted requestNotPermitted) {
        log.info("Auth Service Fallback method called.");
        log.info("RequestNotPermitted exception message: {}", requestNotPermitted.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(CIRCUIT_BREAKER_FALLBACK_MSG);
    }

}
