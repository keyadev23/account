package com.tsb.account.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsb.account.dto.accountdto.Account;
import com.tsb.account.dto.accountdto.AccountResponseDto;
import com.tsb.account.dto.accountdto.LinkedAccount;
import com.tsb.account.exception.CustomException;
import com.tsb.account.model.response.account.AccountResponse;
import com.tsb.account.model.response.account.Data;
import com.tsb.account.service.AuthService;
import com.tsb.account.util.HeadersUtil;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.util.retry.Retry;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest()
@TestPropertySource(locations = "classpath:application-test.properties")
@ExtendWith(SpringExtension.class)
class AccountServiceImplTest {
    private static final Logger logger = LogManager.getLogger(AccountServiceImplTest.class);
    public static MockWebServer mockBackEnd;

    private static AuthServiceImpl authService;
    @Mock
    private WebClient webClientMock;
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
    private Mono<AccountResponseDto> postResponseMock;
    @InjectMocks
    private AccountServiceImpl accountServiceMock;

    public static ObjectMapper objectMapper;

    @BeforeAll
    static void setUp() throws IOException {
        mockBackEnd = new MockWebServer();
        objectMapper = new ObjectMapper();
        authService = new AuthServiceImpl();
        mockBackEnd.start(8080);

    }

    @AfterAll
    static void tearDown() throws IOException {
        mockBackEnd.shutdown();
    }

    @BeforeEach
    void initialize() {
        accountServiceMock = new AccountServiceImpl(authService, webClientMock);
     }

    @Test
    void getAccount_test() throws Exception {
        AccountResponse accountObj = new AccountResponse(Data.builder().build());

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
    @Test
    void getAccount_nextTest() throws Exception{

        LinkedAccount linked = new LinkedAccount("UK.OBIE.SortCodeAccountNumber",
                "80200110203345", "Mr Kevin", "00021");
        ArrayList<LinkedAccount> linkedAccountList = new ArrayList<>();
        linkedAccountList.add(linked);
        Account account = new Account("22289", "Enabled", "2019-01-01T06:06:06+00:00", "GBP",
                "Personal", "CurrentAccount",
                "Bills", linkedAccountList);
        ArrayList<Account> accountList = new ArrayList<>();
        accountList.add(account);
        com.tsb.account.dto.accountdto.Data data = new com.tsb.account.dto.accountdto.Data(new ArrayList<>(accountList));
        AccountResponseDto respDto = new AccountResponseDto(data);
        List<AccountResponseDto> respDtoList = new ArrayList<>();
        respDtoList.add(respDto);

        mockBackEnd.enqueue(new MockResponse()
                .setBody(objectMapper.writeValueAsString(respDtoList))
                .addHeader("Content-Type", "application/json")
                .setResponseCode(200));

        WebClient webClient = WebClient
                .create(String.format("http://%s:8080", mockBackEnd.getHostName()));
        String _token = authService.getToken().map(token -> token.token()).toString();
        HttpHeaders httpHeaders = HeadersUtil.AuthHeader(_token);
        httpHeaders.set("x-fapi-auth-date", "Sun, 10 Sep 2017 19:43:31 GMT");
        httpHeaders.set("x-fapi-customer-ip-address", "104.25.212.99");
        httpHeaders.set("x-fapi-interaction-id", "93bac548-d2de-4546-b106-880a5018460d");
        httpHeaders.set("Accept", "application/json");
        UriComponentsBuilder componentsBuilder = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8080/v1/accounts/")
                .path("22289");



        Mono<List<AccountResponseDto>> _response= webClient.get()
                .uri(componentsBuilder.toUriString())
                .headers(headers -> headers.addAll(httpHeaders))
                .retrieve()
                .onStatus(HttpStatusCode::isError,
                        response -> response.bodyToMono(String.class).flatMap(errorBody -> {
                            logger.error("Error accounts status code {}, response body: {}", response.statusCode(), errorBody);
                            CustomException customException = new CustomException("451", "Failed to fetch accounts");
                            return Mono.error(customException);
                        }))
                .bodyToMono(String.class)
                .map(response -> {
                    try {
                        logger.info("Account response {}", response);
                        return objectMapper.readValue(response, new TypeReference<List<AccountResponseDto>>() {
                        });
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                }).retryWhen(Retry.fixedDelay(1, Duration.ofMillis(10)));

       Flux<AccountResponseDto> getResponse = _response.flatMapMany(Flux::fromIterable)
                .log();



        StepVerifier.create(getResponse)
                .enableConditionalSupport(s -> true)
                .assertNext(e -> {
                    assertThat(e);
                    assertEquals("22289", e.getData().getAccount().get(0).getAccountId());
                })
                .expectComplete()
                .verify();;

        RecordedRequest request = mockBackEnd.takeRequest();
        assertEquals("GET", request.getMethod());

    }

}