package com.tsb.account.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsb.account.dto.accountdto.AccountResponseDto;
import com.tsb.account.service.impl.AccountServiceImpl;
import com.tsb.account.service.impl.AuthServiceImpl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


@SpringBootTest()
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:application-test.properties")
class AccountControllerTest {

    @Value("classpath:files/account-22289.json")
    Resource resourceFile;
    public static MockWebServer mockBackEnd;
    public static ObjectMapper objectMapper;
    @Autowired
    AccountServiceImpl accountService;
    @Mock
    private WebClient webClientMock;
    @InjectMocks
    private AccountController accountController;

    @BeforeAll
    static void setUp() throws IOException {
        mockBackEnd = new MockWebServer();
        objectMapper = new ObjectMapper();
        mockBackEnd.start(8080);

    }

    @AfterAll
    static void tearDown() throws IOException {
        mockBackEnd.shutdown();
    }

    @BeforeEach
    void initialize() {
        accountController = new AccountController(accountService);
        accountService = new AccountServiceImpl(new AuthServiceImpl(), webClientMock);
    }

    @Test
    void getAccount_test() throws IOException, InterruptedException {
        File resource = resourceFile.getFile();
        byte[] byteArray = Files.readAllBytes(resource.toPath());
        mockBackEnd.enqueue(new MockResponse()
                .setBody(new String(byteArray))
                .addHeader("Content-Type", "application/json")
                .setResponseCode(200));


        Flux<AccountResponseDto> response = accountController.getAccount("Sun, 10 Sep 2017 19:43:31 GMT",
                "104.25.212.99",
                "93bac548-d2de-4546-b106-880a5018460d",
                "application/json",
                "22289");

        StepVerifier.create(response)
                .expectNextMatches(accountResp -> {
                    return "22289".contentEquals(accountResp.getData().getAccount().get(0).getAccountId());

                })
                .verifyComplete();

        RecordedRequest request = mockBackEnd.takeRequest();
        Assertions.assertEquals("GET", request.getMethod());
        Assertions.assertNotNull(request.getHeader("Authorization"));
    }
}