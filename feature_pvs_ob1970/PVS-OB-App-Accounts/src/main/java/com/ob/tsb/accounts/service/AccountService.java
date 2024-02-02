package com.ob.tsb.accounts.service;

import com.ob.tsb.accounts.dto.consentDto.ConsentResponse;
import com.ob.tsb.accounts.response.AccountsResponse;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface AccountService {
    Mono<ResponseEntity<AccountsResponse>> getAccounts(String authorization);

    Mono<ResponseEntity<AccountsResponse>> getAccountById(String authorization, String accountId);

    ConsentResponse getConsents(String consentId);

}
