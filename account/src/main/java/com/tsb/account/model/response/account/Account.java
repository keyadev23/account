package com.tsb.account.model.response.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
@JsonInclude(value = JsonInclude.Include.NON_EMPTY,
        content = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public record Account(
        @JsonProperty("AccountId") String AccountId,
        @JsonProperty("Status") String status,
        @JsonProperty("StatusUpdateDateTime") String statusUpdateDateTime,
        @JsonProperty("Currency") String currency,
        @JsonProperty("AccountType") String AccountType,
        @JsonProperty("AccountSubType") String accountSubType,
        @JsonProperty("Nickname") String nickname,
        @JsonProperty("Account") LinkedAccount linkedAccount
) {
}
