package com.ob.tsb.accounts.dto.currentAccountDto;

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
public class CurrentAccountResponse {
    @JsonProperty("ProductInstanceReference")
    public ProductInstanceReference productInstanceReference;
    @JsonProperty("CurrentAccountNumber")
    public CurrentAccountNumber currentAccountNumber;
    @JsonProperty("Accountidentification")
    public Accountidentification accountidentification;
    @JsonProperty("CustomerReference")
    public CustomerReference customerReference;
    @JsonProperty("BankBranchLocationReference")
    public BankBranchLocationReference bankBranchLocationReference;
    @JsonProperty("CurrentAccountType")
    public CurrentAccountType currentAccountType;
    @JsonProperty("AccountCurrency")
    public String accountCurrency;
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
    @JsonProperty("Associations")
    public Associations associations;
    @JsonProperty("AssociationType")
    public String associationType;
    @JsonProperty("AssociationObligationorEntitlement")
    public AssociationObligationorEntitlement associationObligationorEntitlement;
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
    @JsonProperty("AccountDateType")
    public String accountDateType;
    @JsonProperty("AccountDate")
    public String accountDate;
    @JsonProperty("AccountBalance")
    public AccountBalance accountBalance;
    @JsonProperty("Accountbalance")
    public AccountbalanceDetails accountbalance;
    @JsonProperty("CreditLine")
    public List<CreditLine> creditLine;
    @JsonProperty("CurrentAccountProductName")
    public String currentAccountProductName;
    @JsonProperty("CurrentAccountProductID")
    public CurrentAccountProductID currentAccountProductID;
    @JsonProperty("CurrentAccountProductType")
    public String currentAccountProductType;
    @JsonProperty("CurrntAccountProductMarketingStateID")
    public CurrntAccountProductMarketingStateID currntAccountProductMarketingStateID;
    @JsonProperty("CurrentAccountSecondaryProductID")
    public CurrentAccountSecondaryProductID currentAccountSecondaryProductID;
}
