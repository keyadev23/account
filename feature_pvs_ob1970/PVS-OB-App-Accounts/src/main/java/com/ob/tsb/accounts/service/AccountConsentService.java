package com.ob.tsb.accounts.service;

import com.ob.tsb.accounts.dto.consentDto.ConsentResponse;
import com.ob.tsb.accounts.response.AccountsResponse;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.List;

public interface AccountConsentService {
    List<String> getAccountDetails(String consentId);
    ConsentResponse getConsentDetails(String consentId);
}
