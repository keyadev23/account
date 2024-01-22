package com.ob.tsb.accounts.mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ob.tsb.accounts.dto.consentDto.ConsentResponse;
import com.ob.tsb.accounts.dto.corporateCurrentAccountDto.CorporateCurrentAccountResponse;
import com.ob.tsb.accounts.dto.currentAccountDto.CurrentAccountResponse;
import com.ob.tsb.accounts.exception.ResourceNotFoundException;
import com.ob.tsb.accounts.response.AccountsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RestController
@ControllerAdvice
@Slf4j
@RequestMapping("/api/v1/mock")
public class MockController {
    private final ObjectMapper objectMapper;
    private final ResourceLoader resourceLoader;
    @Value("classpath:Mock/currentAccount.json")
    Resource caResourceFile;
    @Value("classpath:Mock/corporateCurrentAccount.json")
    Resource ccaResourceFile;

    public MockController(ObjectMapper objectMapper, ResourceLoader resourceLoader) {
        this.objectMapper = objectMapper;
        this.resourceLoader = resourceLoader;
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
            throw new ResourceNotFoundException(HttpStatus.NO_CONTENT, "Mock response not found");
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
            throw new ResourceNotFoundException(HttpStatus.NO_CONTENT, "Mock response not found");
        }
    }

    @GetMapping("/consent/{consentId}")
    public ConsentResponse getConsentDetails(@PathVariable("consentId") String mConsentId) {
        try {
            Resource resource = new ClassPathResource("mock/consent.json");

            InputStream inputStream = resource.getInputStream();
            byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);

            return objectMapper.readValue(new String(bytes, StandardCharsets.UTF_8), ConsentResponse.class);
        } catch (Exception e) {
            log.error(" Error while reading accounts by id api mock response file");
            throw new ResourceNotFoundException(HttpStatus.NO_CONTENT, "Mock response not found");
        }
    }

    @GetMapping("/CurrentAccountFacility/Retrieve")
    public CurrentAccountResponse getBIANCurrentAccount() {
        try {

            InputStream inputStream = caResourceFile.getInputStream();
            byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);

            return objectMapper.readValue(new String(bytes, StandardCharsets.UTF_8), CurrentAccountResponse.class);
        } catch (Exception e) {
            log.error(" Error while reading accounts by id api mock response file");
            throw new ResourceNotFoundException(HttpStatus.NO_CONTENT, "Mock response not found");
        }
    }

    @GetMapping("/CorporateCurrentAccountFacility/Retrieve")
    public CorporateCurrentAccountResponse getBIANCorporateCurrentAccount() {
        try {

            InputStream inputStream = ccaResourceFile.getInputStream();
            byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);

            return objectMapper.readValue(new String(bytes, StandardCharsets.UTF_8), CorporateCurrentAccountResponse.class);
        } catch (Exception e) {
            log.error(" Error while reading accounts by id api mock response file");
            throw new ResourceNotFoundException(HttpStatus.NO_CONTENT, "Mock response not found");
        }
    }


}
