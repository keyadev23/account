package com.ob.tsb.accounts.controller;

import com.ob.tsb.accounts.dto.consentDto.ConsentResponse;
import com.ob.tsb.accounts.response.AccountsResponse;
import com.ob.tsb.accounts.service.AccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@ControllerAdvice
public class AccountController {

    private final AccountService accountService;

    @Value("${consent.id}")
    private String consentId;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/api/v1/accounts")
    public Mono<ResponseEntity<AccountsResponse>> getAccounts(@RequestHeader("x-fapi-auth-date") String xFapiAuthDate,
                                                             @RequestHeader("x-fapi-customer-ip-address") String xFapiCustomerIpAddress,
                                                             @RequestHeader("x-fapi-interaction-id") String xFapiInteractionId,
                                                             @RequestHeader("Accept") String accept, ServerWebExchange exchange){

        return accountService.getAccounts(xFapiAuthDate, xFapiCustomerIpAddress, xFapiInteractionId, accept);
    }

    void setListData(ConsentResponse c){


    }
}
