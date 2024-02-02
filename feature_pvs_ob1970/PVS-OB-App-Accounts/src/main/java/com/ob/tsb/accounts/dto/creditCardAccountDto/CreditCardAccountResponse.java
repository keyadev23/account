package com.ob.tsb.accounts.dto.creditCardAccountDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditCardAccountResponse {
    @JsonProperty("Accountidentification")
    public Accountidentification accountidentification;
    @JsonProperty("CustomerReference")
    public CustomerReference customerReference;
    @JsonProperty("AccountCurrency")
    public String accountCurrency;
   /* @JsonProperty("AssociationReference")
    public AssociationReference associationReference;
    @JsonProperty("AccountDetails")
    public AccountDetails accountDetails;
    @JsonProperty("Accountbalance")
    public Accountbalance accountbalance;
    @JsonProperty("CreditLine")
    public ArrayList<CreditLine> creditLine;*/
    @JsonProperty("CreditCardProductType")
    public String creditCardProductType;
}
