package com.ob.tsb.accounts.controller;


import com.ob.tsb.accounts.response.AccountsResponse;
import com.ob.tsb.accounts.setup.BaseControllerMockedTest;
import com.ob.tsb.accounts.util.JsonUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import reactor.core.publisher.Mono;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class AccountsControllerTest extends BaseControllerMockedTest {




    @Test
    @DisplayName("Success - Get accounts API")
    void accountsSuccessTest(){
        String authorization = "";
        String xFapiAuthDate = "";
        String xFapiCustomerIpAddress = "";
        String xFapiInteractionId = "";
        String accept = "application/json";

        assertTrue(authClient.validatePrivileage("test_token"));
        assertFalse(authClient.validatePrivileage("test_token_invalid"));

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

       /* ResponseEntity<AccountsResponse> responseEntity = new ResponseEntity<>(
                accountsResponse,
                header,
                HttpStatus.OK
        );*/

       /* AccountsResponse expected =  mockController.getAccounts();
        when(mockController.getAccounts()).thenReturn(expected);

        Mono<AccountsResponse> actual =  accountService.getAccounts().map(accountsResponseResponseEntity -> accountsResponseResponseEntity.getBody());
        when(accountService.getAccounts()).thenReturn(actual);


        Assertions.assertEquals(Mono.just(expected), actual, "Accounts response objects should be equal");
        verify(mockController, times(1)).getAccounts();*/

     //   when(accountService.getAccounts()).thenReturn(Mono.just((ResponseEntity.ok().body(accountsResponse))));



    }

   /* @Test
    @DisplayName("Error - Get accounts API")
    void accountsErrorTest(){


    }


    @Test
    @DisplayName("Success - Get account by id API")
    void accountsByIdSuccessTest(){


    }

    @Test
    @DisplayName("Error - Get account by id API")
    void accountsByIdErrorTest(){


    }*/

}
