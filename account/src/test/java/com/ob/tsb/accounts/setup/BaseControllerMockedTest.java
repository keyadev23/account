package com.ob.tsb.accounts.setup;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ob.tsb.accounts.client.AccountsClient;
import com.ob.tsb.accounts.client.AuthClient;
import com.ob.tsb.accounts.controller.AccountsController;
import com.ob.tsb.accounts.mock.MockController;
import com.ob.tsb.accounts.response.AccountsResponse;
import com.ob.tsb.accounts.service.AccountService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.File;

@WebFluxTest(AccountsController.class)
public class BaseControllerMockedTest {

    @Autowired
    protected AuthClient authClient;

    @MockBean
    protected MockController mockController;

    @Autowired
    protected AccountsClient accountsClient;

    @Autowired
    protected AccountService accountService;

    @Autowired
    protected ObjectMapper objectMapper;

    protected AccountsResponse accountsResponse;


    @SneakyThrows
    @BeforeEach
    void setup() {
        accountsResponse = objectMapper.readValue(new File("src/main/resources/openapi/fakeResponse.json"), AccountsResponse.class);
    }


}
