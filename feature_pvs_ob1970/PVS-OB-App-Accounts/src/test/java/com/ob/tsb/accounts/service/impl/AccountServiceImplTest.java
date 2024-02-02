package com.ob.tsb.accounts.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ob.tsb.accounts.client.AccountsClient;
import com.ob.tsb.accounts.dto.consentDto.ConsentResponse;
import com.ob.tsb.accounts.enums.AccountSubType;
import com.ob.tsb.accounts.response.AccountsResponse;
import com.ob.tsb.accounts.response.AccountsResponseData;
import com.ob.tsb.accounts.response.AccountsResponseDataAccountInner;
import com.ob.tsb.accounts.util.ConsentStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:application-test.properties")
class AccountServiceImplTest {


    @Value("classpath:consent.json")
    Resource cResourceFile;
    ObjectMapper objectMapper;
    @InjectMocks
    AccountServiceImpl accountService;
    @Value("${consent.url}")
    private String consentUrl;
    @Value("${currentAccount.url}")
    private String currentAccountUrl;
    @Value("${corporateCurrentAccount.url}")
    private String corporateCurrentAccountUrl;
    @Value("${creditCardAccount.url}")
    private String creditCardAccountUrl;
    @Value("${consent.id}")
    private String consentId;
    @Value("auth.token")
    private String token;
    @Mock
    private AccountsClient accountsClient;
    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        accountService = new AccountServiceImpl(accountsClient);
        accountService.setConsentUrl(consentUrl);
        accountService.setConsentId(consentId);
        accountService.setCurrentAccountUrl(currentAccountUrl);
        accountService.setCorporateCurrentAccountUrl(corporateCurrentAccountUrl);
        accountService.setCreditCardAccountUrl(creditCardAccountUrl);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAccounts_test() {
        ConsentStatus consentStatus = ConsentStatus.AUTHORISED;
        List<String> typeList = new ArrayList<>();
        ConsentResponse response = accountService.getConsents(consentId);
        Assertions.assertNotNull(response);
        Assertions.assertTrue(response.getData().getAccounts().contains(AccountSubType.CurrentAccount.name()));
        Assertions.assertTrue(response.getData().getAccounts().contains(AccountSubType.CorporateCurrentAccount.name()));
        Assertions.assertTrue(response.getData().getAccounts().contains(AccountSubType.CreditCardAccount.name()));
        typeList.addAll(response.getData().getAccounts());
        AccountsResponse accountResponse = new AccountsResponse();
        List<AccountsResponseDataAccountInner> accountList = new ArrayList<>();

        if (typeList.contains(AccountSubType.CurrentAccount.name())) {
            AccountsResponseDataAccountInner account = new AccountsResponseDataAccountInner();
            when(accountsClient.getCurrentAccountResponse(currentAccountUrl)).thenReturn(account);
            accountList.add(account);

        }

        if (typeList.contains(AccountSubType.CorporateCurrentAccount.name())) {
            AccountsResponseDataAccountInner account = new AccountsResponseDataAccountInner();
            when(accountsClient.getCurrentAccountResponse(corporateCurrentAccountUrl)).thenReturn(account);
            accountList.add(account);
        }

        if (typeList.contains(AccountSubType.CreditCardAccount.name())) {
            AccountsResponseDataAccountInner account = new AccountsResponseDataAccountInner();
            when(accountsClient.getCurrentAccountResponse(creditCardAccountUrl)).thenReturn(account);
            accountList.add(account);
        }
        AccountsResponseData data = new AccountsResponseData();
        data.setAccount(accountList);
        accountResponse.setData(data);
        Mono<AccountsResponse> monoResponse = Mono.just(accountResponse);

        StepVerifier.create(monoResponse)
                .enableConditionalSupport(s -> true)
                .assertNext(e -> {
                    assertThat(e);
                    assertNotNull(e);

                })
                .expectComplete()
                .verify();


    }

    @Test
    void getAccounts_test_next() {

        Mono<ResponseEntity<AccountsResponse>> response = accountService.getAccounts(token);

        Assertions.assertNotNull(response);
        List<AccountsResponseDataAccountInner> list = response.block().getBody().getData().getAccount();
        Assertions.assertEquals(3, list.size());

    }

    @Test
    void getConsents_test() throws IOException {
        UriComponentsBuilder componentsBuilder = UriComponentsBuilder
                .fromHttpUrl(consentUrl)
                .path(consentId);
        InputStream inputStream = cResourceFile.getInputStream();
        byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);
        String jsonStr = new String(bytes);

        ConsentResponse consent = objectMapper.readValue(jsonStr, ConsentResponse.class);

        Mockito.when(restTemplate.getForObject(componentsBuilder.toUriString(), ConsentResponse.class))
                .thenReturn(consent);
        assertEquals("urn-alphabank-intent-88379", consent.getData().getConsentId());

        ConsentResponse consentResponse = accountService.getConsents("urn-alphabank-intent-88379");
        Assertions.assertEquals(consent.getData().getAccounts(), consentResponse.getData().getAccounts());

    }
}