package com.ob.tsb.accounts.dto.corporateCurrentAccountDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDetails {
    @JsonProperty("BaseCurrency")
    public String baseCurrency;
    @JsonProperty("Identification")
    public String identification;
    @JsonProperty("ParentAccount")
    public String parentAccount;
    @JsonProperty("SubAccount")
    public String subAccount;
    @JsonProperty("RelatedFundProcessingCharacteristics")
    public String relatedFundProcessingCharacteristics;
    @JsonProperty("Status")
    public String status;
    @JsonProperty("Language")
    public String language;
    @JsonProperty("PartyRole")
    public String partyRole;
    @JsonProperty("TradePartyRole")
    public String tradePartyRole;
    @JsonProperty("ReportingCurrency")
    public String reportingCurrency;
    @JsonProperty("AccountRestriction")
    public String accountRestriction;
    @JsonProperty("SettlementPartyRole")
    public String settlementPartyRole;
    @JsonProperty("Purpose")
    public String purpose;
    @JsonProperty("ClosingDate")
    public String closingDate;
    @JsonProperty("LiveDate")
    public OffsetDateTime liveDate;
    @JsonProperty("ReportedPeriod")
    public String reportedPeriod;
    @JsonProperty("InvestmentFundPartyRole")
    public String investmentFundPartyRole;
    @JsonProperty("RelatedCollateralProcess")
    public String relatedCollateralProcess;
    @JsonProperty("Type")
    public String type;
    @JsonProperty("RelatedProceedsDelivery")
    public String relatedProceedsDelivery;
    @JsonProperty("RelatedCorporateActionPartyRole")
    public String relatedCorporateActionPartyRole;
    @JsonProperty("DefaultFundAccountOwner")
    public String defaultFundAccountOwner;
    @JsonProperty("System")
    public String system;
    @JsonProperty("Balance")
    public String balance;
    @JsonProperty("Entry")
    public String entry;
    @JsonProperty("AccountContract")
    public String accountContract;
    @JsonProperty("OpeningDate")
    public String openingDate;
    @JsonProperty("CurrencyExchange")
    public String currencyExchange;
    @JsonProperty("DefaultFundContribution")
    public String defaultFundContribution;
    @JsonProperty("SystemMember")
    public String systemMember;
    @JsonProperty("CollateralAccountType")
    public String collateralAccountType;
    @JsonProperty("AccountService")
    public String accountService;
    @JsonProperty("Reconciliation")
    public String reconciliation;
    @JsonProperty("ManagedAccountProduct")
    public String managedAccountProduct;
}
