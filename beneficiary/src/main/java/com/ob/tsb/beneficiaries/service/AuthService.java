package com.ob.tsb.beneficiaries.service;


import com.tsb.account.model.response.token.TokenResponse;
import reactor.core.publisher.Mono;

public interface AuthService {
    Mono<TokenResponse> getToken();
}
