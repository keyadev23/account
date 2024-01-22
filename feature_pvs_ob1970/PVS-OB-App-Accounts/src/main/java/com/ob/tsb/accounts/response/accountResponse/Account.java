package com.ob.tsb.accounts.response.accountResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {

    @JsonIgnoreProperties("AccountId")
    private String accountId;
    @JsonIgnoreProperties("Account")
    private List<AccountProduct> accountProductList;
    @JsonIgnoreProperties("AccountSubType")
    private String accountSubType;
    @JsonIgnoreProperties("AccountType")
    private String accountType;
    @JsonIgnoreProperties("Currency")
    private String currency;
    @JsonIgnoreProperties("Nickname")
    private String nickname;
    @JsonIgnoreProperties("OpeningDate")
    private String openingDate;
    @JsonIgnoreProperties("Status")
    private String status;
    @JsonIgnoreProperties("StatusUpdateDateTime")
    private String statusUpdateDateTime;
}
