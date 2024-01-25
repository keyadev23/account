package com.ob.tsb.accounts.dto.corporateCurrentAccountDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountBalance {
    @JsonProperty("Type")
    public String type;
    @JsonProperty("ValueDate")
    public String valueDate;
    @JsonProperty("CreditDebitIndicator")
    public String creditDebitIndicator;
    @JsonProperty("AssetHolding")
    public String assetHolding;
    @JsonProperty("CalculationDate")
    public String calculationDate;
    @JsonProperty("Adjustment")
    public String adjustment;
    @JsonProperty("Account")
    public String account;
    @JsonProperty("Interest")
    public String interest;
    @JsonProperty("BalanceEntry")
    public String balanceEntry;
    @JsonProperty("ProcessingRestriction")
    public String processingRestriction;
    @JsonProperty("OpeningClosingCode")
    public String openingClosingCode;
}
