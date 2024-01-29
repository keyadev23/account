package com.ob.tsb.accounts.client;

import com.ob.tsb.accounts.dto.corporateCurrentAccountDto.CorporateCurrentAccountResponse;
import com.ob.tsb.accounts.dto.corporateCurrentAccountDto.mapstruct.BianCorporateMapper;
import com.ob.tsb.accounts.dto.corporateCurrentAccountDto.mapstruct.BianMapperCorporate;
import com.ob.tsb.accounts.dto.creditCardAccountDto.CreditCardAccountResponse;
import com.ob.tsb.accounts.dto.creditCardAccountDto.mapstruct.BianCreditCardMapper;
import com.ob.tsb.accounts.dto.currentAccountDto.CurrentAccountResponse;
import com.ob.tsb.accounts.dto.currentAccountDto.mapstruct.BianDtoMapper;
import com.ob.tsb.accounts.exception.CustomException;
import com.ob.tsb.accounts.response.AccountsResponse;
import com.ob.tsb.accounts.response.AccountsResponseDataAccountInner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static com.ob.tsb.accounts.exception.ErrorConstants.AUTH_CLIENT_ERROR;
import static com.ob.tsb.accounts.exception.ErrorConstants.AUTH_SERVER_ERROR;
import static com.ob.tsb.accounts.exception.ErrorDesc.handle4xxClientError;
import static com.ob.tsb.accounts.exception.ErrorDesc.handle5xxClientError;

@Component
@Slf4j
public class AccountsClient {
    private final WebClient webClient;


    public AccountsClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<ResponseEntity<AccountsResponse>> processAccountApiRequest(String url, HttpMethod httpMethod, HttpHeaders headers, LinkedMultiValueMap payload) {
        log.info("url : " + url);
        try {
            Mono<AccountsResponse> accountsResponseMono = webClient.method(httpMethod).uri(url)
                    .headers(httpHeaders -> httpHeaders.addAll(headers))
                    .bodyValue(payload)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> handle4xxClientError(AUTH_CLIENT_ERROR, clientResponse))
                    .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> handle5xxClientError(AUTH_SERVER_ERROR, clientResponse))
                    .bodyToMono(AccountsResponse.class);
            return accountsResponseMono.map(accountsResponse ->
                    ResponseEntity.ok(accountsResponse));
        } catch (Exception e) {
            throw new CustomException(HttpStatusCode.valueOf(500), "Something went wrong");
        }

    }

    public AccountsResponseDataAccountInner getCurrentAccountResponse(String url) {
        log.info("url : " + url);
        try {
            RestTemplate restTemplate = new RestTemplate();
            CurrentAccountResponse response = restTemplate.getForObject(url, CurrentAccountResponse.class);
            AccountsResponseDataAccountInner arResponse = BianDtoMapper.bianToOb(response);
            return arResponse;
        } catch (Exception e) {
            throw new CustomException(HttpStatusCode.valueOf(500), "Something went wrong");
        }


    }
    public AccountsResponseDataAccountInner getCorporateCurrentAccountResponse(String url, HttpHeaders headers) {
        log.info("url : " + url);
        try {
            RestTemplate restTemplate = new RestTemplate();
            CorporateCurrentAccountResponse response = restTemplate.getForObject(url, CorporateCurrentAccountResponse.class);
            AccountsResponseDataAccountInner arResponse = BianCorporateMapper.bianToOb(response);
            return arResponse;
        } catch (Exception e) {
            throw new CustomException(HttpStatusCode.valueOf(500), "Something went wrong");
        }


    }
    public AccountsResponseDataAccountInner getCreditCardAccountResponse(String url, HttpHeaders headers) {
        log.info("url : " + url);
        try {
            RestTemplate restTemplate = new RestTemplate();
            CreditCardAccountResponse response = restTemplate.getForObject(url, CreditCardAccountResponse.class);
            AccountsResponseDataAccountInner arResponse = BianCreditCardMapper.bianToOb(response);
            return arResponse;
        } catch (Exception e) {
            throw new CustomException(HttpStatusCode.valueOf(500), "Something went wrong");
        }


    }
}
