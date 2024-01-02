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
public class BIANResponse {
    @JsonProperty("ProductInstanceReference")
    public ProductInstanceReference productInstanceReference;
    @JsonProperty("CurrentAccountNumber")
    public CurrentAccountNumber currentAccountNumber;
    @JsonProperty("CustomerReference")
    public CustomerReference customerReference;
    @JsonProperty("BankBranchLocationReference")
    public BankBranchLocationReference bankBranchLocationReference;
    @JsonProperty("AccountType")
    public String accountType;
    @JsonProperty("AccountCurrency")
    public AccountCurrency accountCurrency;
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
    public AccountDate accountDate;
    @JsonProperty("AccountBalance")
    public AccountBalance accountBalance;
    @JsonProperty("CurrentAccountProductName")
    public CurrentAccountProductName currentAccountProductName;
    @JsonProperty("CurrentAccountProductID")
    public CurrentAccountProductID currentAccountProductID;
    @JsonProperty("CurrentAccountProductType")
    public String currentAccountProductType;
    @JsonProperty("CurrntAccountProductMarketingStateID")
    public CurrntAccountProductMarketingStateID currntAccountProductMarketingStateID;
    @JsonProperty("CurrentAccountSecondaryProductID")
    public CurrentAccountSecondaryProductID currentAccountSecondaryProductID;
}
