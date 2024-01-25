package com.ob.tsb.accounts.service;

import com.ob.tsb.accounts.dto.consentDto.ConsentResponse;
import com.ob.tsb.accounts.response.AccountsResponse;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface AccountService {
    Mono<ResponseEntity<AccountsResponse>> getAccounts();

    Mono<ResponseEntity<AccountsResponse>> getAccountById(String accountId);


    Mono<ResponseEntity<AccountsResponse>> getAccounts(String xFapiAuthDate, String xFapiCustomerIpAddress, String xFapiInteractionId, String accept);

    ConsentResponse getConsents(String consentId);

}
