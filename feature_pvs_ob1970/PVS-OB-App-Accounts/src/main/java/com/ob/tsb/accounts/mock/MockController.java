package com.ob.tsb.accounts.mock;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@RestController
@ControllerAdvice
@Slf4j
@RequestMapping("/api/v1/mock")
public class MockController {
    @Value("classpath:Mock/currentAccount.json")
    Resource resourceFile;

    private final ObjectMapper objectMapper;

    private final ResourceLoader resourceLoader;

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
       } catch (Exception e){
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
        } catch (Exception e){
            log.error(" Error while reading accounts by id api mock response file");
            throw new ResourceNotFoundException(HttpStatus.NO_CONTENT, "Mock response not found");
        }
    }

    @GetMapping("/CurrentAccountFacility/{currentaccountfacilityid}/Retrieve")
    public CurrentAccountResponse getBIANCurrentAccount(
            @PathVariable("currentaccountfacilityid") String currentaccountfacilityid) {
        try {

            InputStream inputStream = resourceFile.getInputStream();
            byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);

            return objectMapper.readValue(new String(bytes, StandardCharsets.UTF_8), CurrentAccountResponse.class);
        } catch (Exception e){
            log.error(" Error while reading accounts by id api mock response file");
            throw new ResourceNotFoundException(HttpStatus.NO_CONTENT, "Mock response not found");
        }
    }


}
