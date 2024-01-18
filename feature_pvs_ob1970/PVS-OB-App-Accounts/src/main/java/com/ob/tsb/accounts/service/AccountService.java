package com.ob.tsb.accounts.service;

import com.ob.tsb.accounts.dto.corporateCurrentAccountDto.CorporateCurrentAccountResponse;
import com.ob.tsb.accounts.dto.creditCardAccountDto.CreditCardAccountResponse;
import com.ob.tsb.accounts.dto.currentAccountDto.CurrentAccountResponse;
import com.ob.tsb.accounts.response.AccountsResponse;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface AccountService {
    Mono<ResponseEntity<AccountsResponse>> getAccounts(String xFapiAuthDate, String xFapiCustomerIpAddress, String xFapiInteractionId, String accept);
    Mono<ResponseEntity<AccountsResponse>> getAccountById(String accountId);


    CurrentAccountResponse getCurrentAccount();
    CorporateCurrentAccountResponse getCorporateCurrentAccount();
    CreditCardAccountResponse getCreditCardAccount();


}
