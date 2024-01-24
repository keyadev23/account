package com.ob.tsb.accounts.service;

import com.ob.tsb.accounts.dto.consentDto.ConsentResponse;
import com.ob.tsb.accounts.response.AccountsResponse;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.List;

public interface AccountService {
    Mono<ResponseEntity<AccountsResponse>> getAccounts();

    Mono<ResponseEntity<AccountsResponse>> getAccountById(String accountId);

    List<String> getAccountDetailsOfConsent(String consentId);

    ConsentResponse getConsentDetails(String consentId);

    Mono<ResponseEntity<AccountsResponse>> getAccounts(String xFapiAuthDate, String xFapiCustomerIpAddress, String xFapiInteractionId, String accept);


}
