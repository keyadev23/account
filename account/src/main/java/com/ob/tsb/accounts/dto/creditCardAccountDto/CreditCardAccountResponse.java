package com.ob.tsb.accounts.dto.creditCardAccountDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditCardAccountResponse {
    @JsonProperty("ProductInstanceReference")
    public ProductInstanceReference productInstanceReference;
    @JsonProperty("Accountidentification")
    public Accountidentification accountidentification;
    @JsonProperty("CustomerReference")
    public CustomerReference customerReference;
    @JsonProperty("PartyReference")
    public PartyReference partyReference;
    @JsonProperty("BankBranchLocationReference")
    public BankBranchLocationReference bankBranchLocationReference;
    @JsonProperty("AccountCurrency")
    public String accountCurrency;
    @JsonProperty("SecondaryBillingCurrency")
    public String secondaryBillingCurrency;
    @JsonProperty("TaxReference")
    public TaxReference taxReference;
    @JsonProperty("EntitlementOptionDefinition")
    public EntitlementOptionDefinition entitlementOptionDefinition;
    @JsonProperty("EntitlementOptionSetting")
    public EntitlementOptionSetting entitlementOptionSetting;
    @JsonProperty("RestrictionOptionDefinition")
    public RestrictionOptionDefinition restrictionOptionDefinition;
    @JsonProperty("RestrictionOptionSetting")
    public RestrictionOptionSetting restrictionOptionSetting;
    @JsonProperty("AllowedAccess")
    public AllowedAccess allowedAccess;
    @JsonProperty("ConfigurationOptions")
    public ConfigurationOptions configurationOptions;
    @JsonProperty("CreditCardFacilityOptionDefinition")
    public CreditCardFacilityOptionDefinition creditCardFacilityOptionDefinition;
    @JsonProperty("CreditCardFacilityOptionSetting")
    public CreditCardFacilityOptionSetting creditCardFacilityOptionSetting;
    @JsonProperty("Associations")
    public Associations associations;
    @JsonProperty("AssociationType")
    public String associationType;
    @JsonProperty("AssociationObligationEntitlement")
    public AssociationObligationEntitlement associationObligationEntitlement;
    @JsonProperty("AssociationReference")
    public AssociationReference associationReference;
    @JsonProperty("LinkedAccounts")
    public LinkedAccounts linkedAccounts;
    @JsonProperty("LinkType")
    public String linkType;
    @JsonProperty("AccountDetails")
    public AccountDetails accountDetails;
    @JsonProperty("PositionLimits")
    public PositionLimits positionLimits;
    @JsonProperty("PositionLimitType")
    public String positionLimitType;
    @JsonProperty("PositionLimitSettings")
    public PositionLimitSettings positionLimitSettings;
    @JsonProperty("PositionLimitValue")
    public PositionLimitValue positionLimitValue;
    @JsonProperty("DateType")
    public String dateType;
    @JsonProperty("Date")
    public Date date;
    @JsonProperty("AccountBalance")
    public AccountBalance accountBalance;
    @JsonProperty("Accountbalance")
    public AccountbalanceDetails accountbalance;
    @JsonProperty("CreditLine")
    public List<CreditLine> creditLine;
    @JsonProperty("StatementsSchedule")
    public StatementsSchedule statementsSchedule;
    @JsonProperty("StatementType")
    public String statementType;
    @JsonProperty("StatementTransactionType")
    public String statementTransactionType;
    @JsonProperty("StatementPeriod")
    public StatementPeriod statementPeriod;
    @JsonProperty("StatementReport")
    public StatementReport statementReport;
    @JsonProperty("CreditCardProductName")
    public String creditCardProductName;
    @JsonProperty("CreditCardProductType")
    public String creditCardProductType;
    @JsonProperty("CreditCardSecondaryProductID")
    public String creditCardSecondaryProductID;
    @JsonProperty("CreditCardProductID")
    public CreditCardProductID creditCardProductID;
    @JsonProperty("CreditCardProductMarketingStateID")
    public CreditCardProductMarketingStateID creditCardProductMarketingStateID;
    
}
