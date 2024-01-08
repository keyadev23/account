package com.ob.tsb.beneficiaries.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ob.tsb.beneficiaries.model.response.beneficiary.BeneficiaryRespoonse;
import com.ob.tsb.beneficiaries.service.BeneficiaryService;
import com.ob.tsb.beneficiaries.service.impl.AuthServiceImpl;
import com.ob.tsb.beneficiaries.service.impl.BeneficiaryServiceImpl;
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
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest()
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:application-test.properties")
class BeneficiaryControllerTest {
    @Value("classpath:files/beneficiary.json")
    Resource resourceFile;
    public static MockWebServer mockBackEnd;
    public static ObjectMapper objectMapper;

    @Autowired
    BeneficiaryServiceImpl beneficiaryService;
    @Mock
    private WebClient webClientMock;
    @InjectMocks
    private BeneficiaryController beneficiaryController;

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
        beneficiaryController = new BeneficiaryController(beneficiaryService);
        beneficiaryService = new BeneficiaryServiceImpl(new AuthServiceImpl(), webClientMock);

    }

    @Test
    void getBeneficiary_test() throws IOException, InterruptedException {
        File resource = resourceFile.getFile();
        byte[] byteArray = Files.readAllBytes(resource.toPath());
        mockBackEnd.enqueue(new MockResponse()
                .setBody(new String(byteArray))
                .addHeader("Content-Type", "application/json")
                .setResponseCode(200));


        Mono<BeneficiaryRespoonse> response = beneficiaryController.getBeneficiaries("Sun, 10 Sep 2017 19:43:31 GMT",
                "104.25.212.99",
                "93bac548-d2de-4546-b106-880a5018460d",
                "application/json",
                "22290");

        StepVerifier.create(response)
                .expectNextMatches(resp -> {
                    return "22290".contentEquals(resp.getData().getBeneficiary().get(0).getAccountId());

                })
                .verifyComplete();

        RecordedRequest request = mockBackEnd.takeRequest();
        Assertions.assertEquals("GET", request.getMethod());
        Assertions.assertNotNull(request.getHeader("Authorization"));
    }

}