package com.ob.tsb.accounts.dto.currentAccountDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BalanceAmount {
    @JsonProperty("AmountValue")
    public AmountValue amountValue;
    @JsonProperty("AmountCurrency")
    public AmountCurrency amountCurrency;
    @JsonProperty("DecimalPointPosition")
    public String decimalPointPosition;
    @JsonProperty("AmountType")
    public String amountType;
}
