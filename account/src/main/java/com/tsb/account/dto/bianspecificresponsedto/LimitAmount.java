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
public class LimitAmount {
    @JsonProperty("AmountValue")
    public AmountValue amountValue;
    @JsonProperty("AmountCurrency")
    public AmountCurrency amountCurrency;
    @JsonProperty("DecimalPointPosition")
    public String decimalPointPosition;
    @JsonProperty("AmountType")
    public String amountType;
}
