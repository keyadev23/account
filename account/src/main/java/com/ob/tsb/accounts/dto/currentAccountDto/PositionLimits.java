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
public class PositionLimits {
    @JsonProperty("Type")
    public String type;
    @JsonProperty("Amount")
    public String amount;
    @JsonProperty("CreditDebitIndicator")
    public String creditDebitIndicator;
    @JsonProperty("UsedAmount")
    public String usedAmount;
    @JsonProperty("UsedPercentage")
    public String usedPercentage;
    @JsonProperty("Currency")
    public String currency;
    @JsonProperty("LimitStatus")
    public String limitStatus;
    @JsonProperty("Percentage")
    public String percentage;
    @JsonProperty("RelatedDebitCreditFacility")
    public String relatedDebitCreditFacility;
    @JsonProperty("Periodicity")
    public String periodicity;
    @JsonProperty("Quantity")
    public String quantity;
    @JsonProperty("ValidityPeriod")
    public String validityPeriod;
    @JsonProperty("RelatedPaymentCard")
    public String relatedPaymentCard;
    @JsonProperty("AvailableAmount")
    public String availableAmount;

}
