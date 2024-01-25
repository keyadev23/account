package com.ob.tsb.accounts.dto.corporateCurrentAccountDto;

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
public class CorporateCurrentAccountResponse {
    @JsonProperty("ProductInstanceReference")
    public ProductInstanceReference productInstanceReference;
    @JsonProperty("CorporateCurrentAccountNumber")
    public CorporateCurrentAccountNumber corporateCurrentAccountNumber;
    @JsonProperty("Accountidentification")
    public Accountidentification accountidentification;
    @JsonProperty("CustomerReference")
    public CustomerReference customerReference;
    @JsonProperty("BankBranchLocationReference")
    public BankBranchLocationReference bankBranchLocationReference;
    @JsonProperty("CorporateCurrentAccountType")
    public CorporateCurrentAccountType corporateCurrentAccountType;
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
    @JsonProperty("CorporateCurrentAccountProductMarketingStateID")
    public CorporateCurrentAccountProductMarketingStateID corporateCurrentAccountProductMarketingStateID;
    @JsonProperty("CorporateCurrentAccountSecondaryProductID")
    public CorporateCurrentAccountSecondaryProductID corporateCurrentAccountSecondaryProductID;
    @JsonProperty("CorporateCurrentAccountProductName")
    public String corporateCurrentAccountProductName;
    @JsonProperty("CorporateCurrentAccountProductID")
    public CorporateCurrentAccountProductID corporateCurrentAccountProductID;
    @JsonProperty("CorporateCurrentAccountProductType")
    public String corporateCurrentAccountProductType;
}
