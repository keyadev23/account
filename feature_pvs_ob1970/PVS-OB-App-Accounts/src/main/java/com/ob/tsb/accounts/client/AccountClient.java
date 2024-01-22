package com.ob.tsb.accounts.client;

import com.ob.tsb.accounts.dto.currentAccountDto.CurrentAccountResponse;
import com.ob.tsb.accounts.dto.currentAccountDto.mapstruct.BianDtoMapper;
import com.ob.tsb.accounts.exception.CustomException;
import com.ob.tsb.accounts.response.accountResponse.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import static com.ob.tsb.accounts.exception.ErrorConstants.AUTH_CLIENT_ERROR;
import static com.ob.tsb.accounts.exception.ErrorConstants.AUTH_SERVER_ERROR;
import static com.ob.tsb.accounts.exception.ErrorDesc.handle4xxClientError;
import static com.ob.tsb.accounts.exception.ErrorDesc.handle5xxClientError;

@Component
@Slf4j
public class AccountClient {
    private final WebClient webClient;

    public AccountClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Account getCurrentAccountResponse(String url, HttpHeaders headers) {
        log.info("url : " + url);
        try {
            Account accountResponse = webClient.get().uri(url)
                    .headers(httpHeaders -> httpHeaders.addAll(headers))
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> handle4xxClientError(AUTH_CLIENT_ERROR, clientResponse))
                    .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> handle5xxClientError(AUTH_SERVER_ERROR, clientResponse))
                    .bodyToMono(CurrentAccountResponse.class)
                    .map(response -> {
                        log.info("Accounts Response: {}", response);

                        return BianDtoMapper.bianToOb(response);
                    }).block();
            return accountResponse;
        } catch (Exception e) {
            throw new CustomException(HttpStatusCode.valueOf(500), "Something went wrong");
        }


    }
}
