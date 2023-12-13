package com.tsb.account.service;



import com.tsb.account.dto.accountdto.AccountResponseDto;
import com.tsb.account.model.response.account.AccountResponse;

import reactor.core.publisher.Flux;

public interface AccountService {
    Flux<AccountResponseDto> getAccountsById(String authDate,
                                             String customerIpAddress,
                                             String interactionId,
                                             String accept, String accountId);
}
