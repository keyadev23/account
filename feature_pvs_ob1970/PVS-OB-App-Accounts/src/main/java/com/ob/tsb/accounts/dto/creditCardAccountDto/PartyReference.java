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
public class PartyReference {
    @JsonProperty("ContactPoint")
    public String contactPoint;
    @JsonProperty("Identification")
    public String identification;
    @JsonProperty("MoneyLaunderingCheck")
    public String moneyLaunderingCheck;
    @JsonProperty("TaxationConditions")
    public String taxationConditions;
    @JsonProperty("Domicile")
    public String domicile;
    @JsonProperty("Residence")
    public String residence;
    @JsonProperty("PowerOfAttorney")
    public String powerOfAttorney;
    @JsonProperty("Location")
    public String location;
    @JsonProperty("CloseLinkSecurity")
    public String closeLinkSecurity;
    @JsonProperty("CreditQuality")
    public String creditQuality;
    @JsonProperty("ShareholdingType")
    public String shareholdingType;
    @JsonProperty("AccountIdentificationType")
    public String accountIdentificationType;
}
