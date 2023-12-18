package com.tsb.account.dto.accountdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account{
    @JsonProperty("AccountId")
    String accountId;
    @JsonProperty("Status")
    String status;
    @JsonProperty("StatusUpdateDateTime")
    String statusUpdateDateTime;
    @JsonProperty("Currency")
    String currency;
    @JsonProperty("AccountType")
    String accountType;
    @JsonProperty("AccountSubType")
    String accountSubType;
    @JsonProperty("Nickname")
    String nickname;
    @JsonProperty("Account")
    ArrayList<LinkedAccount> linkedAccount;
}
