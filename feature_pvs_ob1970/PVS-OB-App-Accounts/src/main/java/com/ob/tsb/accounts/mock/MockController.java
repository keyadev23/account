package com.ob.tsb.accounts.mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ob.tsb.accounts.dto.consentDto.ConsentResponse;
import com.ob.tsb.accounts.dto.corporateCurrentAccountDto.CorporateCurrentAccountResponse;
import com.ob.tsb.accounts.dto.creditCardAccountDto.CreditCardAccountResponse;
import com.ob.tsb.accounts.dto.currentAccountDto.CurrentAccountResponse;
import com.ob.tsb.accounts.exception.ResourceNotFoundException;
import com.ob.tsb.accounts.response.AccountsResponse;
import com.ob.tsb.accounts.response.basic.Account;
import com.ob.tsb.accounts.response.basic.AccountsResponseDTO;
import com.ob.tsb.accounts.service.AccountService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerWebExchange;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

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
    @Value("classpath:mock/RetrieveCreditCardFacilityResponse.json")
    Resource ccResourceFile;
    @Value("classpath:mock/consent.json")
    Resource cResourceFile;

    public MockController(ObjectMapper objectMapper, AccountService accountService) {
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

    @GetMapping("/accountsByStatus/{status}")
    public AccountsResponseDTO getAccountsByStatus(@Parameter(name = "status", description = "Status of the account to get", required = true, in = ParameterIn.PATH) @PathVariable("status") String status,
                                                   @Parameter(name = "Authorization", description = "", in = ParameterIn.HEADER) @RequestHeader(value = "Authorization", required = false) String authorization,
                                                   @Parameter(name = "x-fapi-auth-date", description = "", in = ParameterIn.HEADER) @RequestHeader(value = "x-fapi-auth-date", required = false) String xFapiAuthDate,
                                                   @Parameter(name = "x-fapi-customer-ip-address", description = "", in = ParameterIn.HEADER) @RequestHeader(value = "x-fapi-customer-ip-address", required = false) String xFapiCustomerIpAddress,
                                                   @Parameter(name = "x-fapi-interaction-id", description = "", in = ParameterIn.HEADER) @RequestHeader(value = "x-fapi-interaction-id", required = false) String xFapiInteractionId,
                                                   @Parameter(name = "Accept", description = "", in = ParameterIn.HEADER) @RequestHeader(value = "Accept", required = false) String accept,
                                                   @Parameter(hidden = true) final ServerWebExchange exchange) {

        AccountsResponseDTO data = new AccountsResponseDTO();
        try {
            Resource resource = new ClassPathResource("openapi/Accounts.json");
            InputStream in = resource.getInputStream();
            byte[] bytes = FileCopyUtils.copyToByteArray(in);

            data = objectMapper.readValue(new String(bytes, StandardCharsets.UTF_8), AccountsResponseDTO.class);
            //System.out.println(data);

            if (data != null) {
                List<Account> accountlist = data.getData().getAccount();

                List<Account> filteredList = accountlist.stream()
                        .filter(account -> account.getStatus().equalsIgnoreCase(status))
                        .collect(Collectors.toList());
                data.getData().setAccount(filteredList);
            }
        } catch (Exception e) {
            log.error(" Error while reading accounts basic api mock response file");
            throw new ResourceNotFoundException(HttpStatus.NO_CONTENT, "Mock response not found");
        }

        return data;
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

            InputStream inputStream = ccResourceFile.getInputStream();
            byte[] bytes = FileCopyUtils.copyToByteArray(inputStream);

            return objectMapper.readValue(new String(bytes, StandardCharsets.UTF_8), CreditCardAccountResponse.class);
        } catch (Exception e) {
            log.error(" Error while reading accounts by id api mock response file");
            throw new ResourceNotFoundException(HttpStatus.NO_CONTENT, "mock response not found");
        }
    }


}
