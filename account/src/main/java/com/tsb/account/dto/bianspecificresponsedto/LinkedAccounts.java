package com.tsb.account.dto.bianspecificresponsedto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LinkedAccounts {
    @JsonProperty("AccountStatus")
    public AccountStatus accountStatus;
    @JsonProperty("AccountIdentification")
    public LinkedAccountIdentification linkedAccountIdentification;
    @JsonProperty("AccountDate")
    public AccountDate accountDate;
    @JsonProperty("AccountType")
    public AccountType accountType;
    @JsonProperty("AccountPurpose")
    public AccountPurpose accountPurpose;
    @JsonProperty("AccountBalance")
    public AccountBalance accountBalance;
    @JsonProperty("AccountCurrency")
    public AccountCurrency accountCurrency;
    @JsonProperty("AccountDescription")
    public AccountDescription accountDescription;
    @JsonProperty("AccountName")
    public AccountName accountName;
}
