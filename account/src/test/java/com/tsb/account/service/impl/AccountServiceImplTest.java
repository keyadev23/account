package com.tsb.account.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsb.account.dto.accountdto.AccountResponseDto;
import com.tsb.account.model.response.account.AccountResponse;
import com.tsb.account.model.response.account.CurrentAccountFacility;
import com.tsb.account.model.response.account.Data;
import com.tsb.account.service.AuthService;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest()
@TestPropertySource(locations="classpath:application-local.properties")
@ExtendWith(SpringExtension.class)
class AccountServiceImplTest {

    @Mock
    private WebClient webClientMock;

    @Autowired
    private AuthService authService;

    @Mock
    private WebClient.RequestBodyUriSpec requestBodyUriSpecMock;

    @Mock
    private WebClient.RequestBodySpec requestBodySpecMock;


    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpecMock;


    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpecMock;

    @Mock
    private WebClient.ResponseSpec responseSpecMock;

    @Mock
    ObjectMapper objectMapper;

    @Mock
    private Mono<AccountResponseDto> postResponseMock;

    @InjectMocks
    private AccountServiceImpl accountServiceMock;

    public static MockWebServer mockBackEnd;


    @BeforeEach
    void initialize() {
        accountServiceMock= new AccountServiceImpl(authService,webClientMock);
        ReflectionTestUtils.setField(accountServiceMock, "gatewayUrl", "http://localhost:3030/v1/accounts/");
    }

    @BeforeAll
    static void setUp() throws IOException {
        mockBackEnd = new MockWebServer();
        mockBackEnd.start();
    }
    @AfterAll
    static void tearDown() throws IOException {
        mockBackEnd.shutdown();
    }

    @Test
    public void getAccount_test() throws Exception{
        AccountResponse accountObj= new AccountResponse(Data.builder().build());

        when(webClientMock.get()).thenReturn(requestHeadersUriSpecMock);
        when(requestHeadersUriSpecMock.uri(anyString())).thenReturn(requestHeadersSpecMock);
        when(requestHeadersSpecMock.retrieve()).thenReturn(responseSpecMock);
        when(responseSpecMock.bodyToMono(
                ArgumentMatchers.<Class<AccountResponse>>notNull()))
                .thenReturn(Mono.just(accountObj));
        Flux<AccountResponseDto> response = accountServiceMock.getAccountsById("Sun, 10 Sep 2017 19:43:31 GMT",
                "104.25.212.99",
                "93bac548-d2de-4546-b106-880a5018460d",
                "application/json",
                "31820");
        Assertions.assertNotEquals(null, response);

    }
   /* @Test
    public void getAccount_nextTest() throws Exception{

        //AccountResponse accountObj= new AccountResponse(Data.builder().build());
        mockBackEnd.enqueue(new MockResponse()
                .setBody(String.valueOf(""))
                .addHeader("x-fapi-auth-date", "Sun, 10 Sep 2017 19:43:31 GMT")
                .addHeader("x-fapi-customer-ip-address", "104.25.212.99")
                .addHeader("x-fapi-interaction-id", "93bac548-d2de-4546-b106-880a5018460d")
                .addHeader("Accept", "application/json")
                .setResponseCode(200));



        Flux<AccountResponseDto> response = accountServiceMock.getAccountsById("Sun, 10 Sep 2017 19:43:31 GMT",
                "104.25.212.99",
                "93bac548-d2de-4546-b106-880a5018460d",
                "application/json",
                "22289");

        StepVerifier.create(response)
                .expectNextMatches(accountResp -> {

                       return "22289".contentEquals(accountResp.getData().getAccount().get(0).getAccountId());

                })
                .verifyComplete();


    }*/

}