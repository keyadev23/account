package com.ob.tsb.accounts.mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ob.tsb.accounts.dto.consentDto.ConsentResponse;
import com.ob.tsb.accounts.dto.corporateCurrentAccountDto.CorporateCurrentAccountResponse;
import com.ob.tsb.accounts.dto.creditCardAccountDto.CreditCardAccountResponse;
import com.ob.tsb.accounts.dto.currentAccountDto.CurrentAccountResponse;
import com.ob.tsb.accounts.exception.ResourceNotFoundException;
import com.ob.tsb.accounts.response.AccountsResponse;
import com.ob.tsb.accounts.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RestController
@ControllerAdvice
@Slf4j
@RequestMapping("/api/v1/mock")
public class MockController {
    private final ObjectMapper objectMapper;

    private final AccountService accountService;
    @Value("classpath:mock/currentAccount.json")
    Resource caResourceFile;
    @Value("classpath:mock/corporateCurrentAccount.json")
    Resource ccaResourceFile;
    @Value("classpath:mock/consent.json")
    Resource cResourceFile;

    public MockController(ObjectMapper objectMapper, ResourceLoader resourceLoader, AccountService accountService) {
        this.objectMapper = objectMapper;
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public AccountsResponse getAccounts() {
        try {
            Resource resource = new ClassPathResource("openapi/fakeResponse.json");

            InputStream inputStream = resource.getInputStream();
            byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);

            return objectMapper.readValue(new String(bytes, StandardCharsets.UTF_8), AccountsResponse.class);
        } catch (Exception e) {
            log.error(" Error while reading accounts api mock response file");
            throw new ResourceNotFoundException(HttpStatus.NO_CONTENT, "mock response not found");
        }
    }

    @GetMapping("/accounts/{accountId}")
    public AccountsResponse getAccountById() {
        try {
            Resource resource = new ClassPathResource("openapi/fakeResponseAccId.json");

            InputStream inputStream = resource.getInputStream();
            byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);

            return objectMapper.readValue(new String(bytes, StandardCharsets.UTF_8), AccountsResponse.class);
        } catch (Exception e) {
            log.error(" Error while reading accounts by id api mock response file");
            throw new ResourceNotFoundException(HttpStatus.NO_CONTENT, "mock response not found");
        }
    }

    @GetMapping("/consent/{consentId}")
    public ConsentResponse getConsentDetails(@PathVariable("consentId") String mConsentId) {
        try {
            InputStream inputStream = cResourceFile.getInputStream();
            byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);
            String jsonStr = new String(bytes);

            return objectMapper.readValue(jsonStr, ConsentResponse.class);
        } catch (Exception e) {
            log.error(" Error while reading accounts by id api mock response file");
            throw new ResourceNotFoundException(HttpStatus.NO_CONTENT, "mock response not found");
        }
    }

    @GetMapping("/currentAccountFacility/retrieve")
    public CurrentAccountResponse getBIANCurrentAccount() {
        try {

            InputStream inputStream = caResourceFile.getInputStream();
            byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);

            return objectMapper.readValue(new String(bytes, StandardCharsets.UTF_8), CurrentAccountResponse.class);
        } catch (Exception e) {
            log.error(" Error while reading accounts by id api mock response file");
            throw new ResourceNotFoundException(HttpStatus.NO_CONTENT, "mock response not found");
        }
    }

    @GetMapping("/corporateCurrentAccountFacility/retrieve")
    public CorporateCurrentAccountResponse getBIANCorporateCurrentAccount() {
        try {

            InputStream inputStream = ccaResourceFile.getInputStream();
            byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);

            return objectMapper.readValue(new String(bytes, StandardCharsets.UTF_8), CorporateCurrentAccountResponse.class);
        } catch (Exception e) {
            log.error(" Error while reading accounts by id api mock response file");
            throw new ResourceNotFoundException(HttpStatus.NO_CONTENT, "mock response not found");
        }
    }
    @GetMapping("/creditCardFacility/retrieve")
    public CreditCardAccountResponse getBIANCreditCardAccount() {
        try {

            InputStream inputStream = caResourceFile.getInputStream();
            byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);

            return objectMapper.readValue(new String(bytes, StandardCharsets.UTF_8), CreditCardAccountResponse.class);
        } catch (Exception e) {
            log.error(" Error while reading accounts by id api mock response file");
            throw new ResourceNotFoundException(HttpStatus.NO_CONTENT, "mock response not found");
        }
    }

}
