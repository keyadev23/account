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
public class AccountCurrency {
    @JsonProperty("AccountCurrencyType")
    public String accountCurrencyType;
    @JsonProperty("AccountCurrency")
    public AccountCurrency accountCurrency;
    @JsonProperty("Currencycode")
    public String currencycode;
}
