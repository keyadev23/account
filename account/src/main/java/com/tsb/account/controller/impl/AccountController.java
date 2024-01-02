package com.tsb.account.controller.impl;


import com.tsb.account.controller.AccountApiVersion;
import com.tsb.account.dto.accountdto.AccountResponseDto;
import com.tsb.account.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class AccountController implements AccountApiVersion {


    private final AccountServiceImpl accountService;

    @Autowired
    public AccountController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }


    @GetMapping("/accounts/{AccountId}")
    public Flux<AccountResponseDto> getAccount(@RequestHeader("AuthDate") String authDate,
                                               @RequestHeader("CustomerIpAddress") String customerIpAddress,
                                               @RequestHeader("InteractionId") String interactionId,
                                               @RequestHeader("Accept") String accept,
                                               @PathVariable("AccountId") String accountId) {
        return accountService.getAccountsById(authDate, customerIpAddress, interactionId, accept, accountId);


    }
}
