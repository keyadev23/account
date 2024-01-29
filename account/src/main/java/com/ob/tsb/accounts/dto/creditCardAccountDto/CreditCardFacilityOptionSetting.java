package com.ob.tsb.accounts.dto.creditCardAccountDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditCardFacilityOptionSetting {
    @JsonProperty("PaymentCard")
    public String paymentCard;
    @JsonProperty("Product")
    public String product;
    @JsonProperty("DetailedAmount")
    public String detailedAmount;
    @JsonProperty("AmountQualifier")
    public String amountQualifier;
    @JsonProperty("CardPaymentAcquiring")
    public String cardPaymentAcquiring;
    @JsonProperty("PaymentCardPartyRole")
    public String paymentCardPartyRole;
    @JsonProperty("CardPaymentStatus")
    public String cardPaymentStatus;
    @JsonProperty("DetailedAmountLabel")
    public String detailedAmountLabel;
    @JsonProperty("Reconciliation")
    public String reconciliation;
    @JsonProperty("TransactionCategory")
    public String transactionCategory;
    @JsonProperty("CashBackAmount")
    public String cashBackAmount;
    @JsonProperty("Gratuity")
    public String gratuity;
    @JsonProperty("DebitCreditDirection")
    public String debitCreditDirection;
    @JsonProperty("ATMTotal")
    public String atmTotal;

}
