package com.tsb.account.service;


import com.tsb.account.dto.accountdto.AccountResponseDto;
import reactor.core.publisher.Flux;

public interface AccountService {
    Flux<AccountResponseDto> getAccountsById(String authDate,
                                             String customerIpAddress,
                                             String interactionId,
                                             String accept, String accountId);
}
