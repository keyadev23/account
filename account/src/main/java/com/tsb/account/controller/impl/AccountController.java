package com.tsb.account.controller.impl;


import com.tsb.account.controller.AccountApiVersion;
import com.tsb.account.model.response.account.AccountResponse;
import com.tsb.account.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class AccountController implements AccountApiVersion {

    @Autowired
    AccountServiceImpl accountService;

    @GetMapping("/getAccount")
    public Flux<AccountResponse> getAccount(@RequestHeader("AuthDate") String authDate,
                                            @RequestHeader("CustomerIpAddress") String customerIpAddress,
                                            @RequestHeader("InteractionId") String interactionId,
                                            @RequestHeader("Accept") String accept) {
        return accountService.getAccounts(authDate, customerIpAddress, interactionId, accept);


    }
}
