package com.ob.tsb.accounts.service;

import org.springframework.http.ResponseEntity;

public interface AuthService {

    boolean validateToken(String token);
    String getAccessToken();
}
