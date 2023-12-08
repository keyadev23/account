package com.tsb.account.service;


import com.tsb.account.model.response.account.AccountResponse;
import reactor.core.publisher.Flux;

public interface AccountService {
    Flux<AccountResponse> getAccounts(String authDate,
                                      String customerIpAddress,
                                      String interactionId,
                                      String accept);
}
