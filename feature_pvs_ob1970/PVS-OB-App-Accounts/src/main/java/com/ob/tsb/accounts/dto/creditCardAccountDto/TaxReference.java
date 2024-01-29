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
public class TaxReference {
    @JsonProperty("Identification")
    public String identification;
    @JsonProperty("IdentificationForContactPoint")
    public String identificationForContactPoint;
    @JsonProperty("IdentificationForAccount")
    public String identificationForAccount;
    @JsonProperty("RelatedPartyIdentification")
    public String relatedPartyIdentification;
    @JsonProperty("IssueDate")
    public String issueDate;
    @JsonProperty("ExpiryDate")
    public String expiryDate;
    @JsonProperty("Scheme")
    public String scheme;
    @JsonProperty("IdentificationForSecuritiesCertificate")
    public String identificationForSecuritiesCertificate;
    @JsonProperty("IdentificationForLot")
    public String identificationForLot;
    @JsonProperty("PartyRole")
    public String partyRole;
    @JsonProperty("IdentificationForCashProceedsIncome")
    public String identificationForCashProceedsIncome;
    @JsonProperty("RelatedStatusReason")
    public String relatedStatusReason;
    @JsonProperty("IdentificationForBankTransaction")
    public String identificationForBankTransaction;
    @JsonProperty("IdentificationForAccountCostReferencePattern")
    public String identificationForAccountCostReferencePattern;
    @JsonProperty("Account")
    public String account;
    @JsonProperty("RelatedSystemIdentification")
    public String relatedSystemIdentification;
    @JsonProperty("IdentificationForInterestName")
    public String identificationForInterestName;
    @JsonProperty("RelatedCashAccountService")
    public String relatedCashAccountService;
    @JsonProperty("IdentificationForInvestmentFundClass")
    public String identificationForInvestmentFundClass;
    @JsonProperty("IdentifiedLocation")
    public String identifiedLocation;
    @JsonProperty("RelatedSecuritiesIdentification")
    public String relatedSecuritiesIdentification;
    @JsonProperty("IdentifiedDocument")
    public String identifiedDocument;
    @JsonProperty("RelatedPurchaseOrder")
    public String relatedPurchaseOrder;
    @JsonProperty("RelatedCertificate")
    public String relatedCertificate;
}
