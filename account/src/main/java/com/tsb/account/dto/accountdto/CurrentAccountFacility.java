package com.tsb.account.dto.accountdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

@NoArgsConstructor(force = true)
@JsonInclude(value = JsonInclude.Include.NON_EMPTY,
        content = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentAccountFacility {
    @JsonProperty("ProductInstanceReference")
    ProductInstanceReference[] productInstanceReference;
    @JsonProperty("CurrentAccountNumber")
    String currentAccountNumber;
    @JsonProperty("CustomerReference")
    CustomerReference customerReference;
    @JsonProperty("BankBranchOrLocationReference")
    BankBranchOrLocationReference bankBranchOrLocationReference;
    @JsonProperty("AccountType")
    AccountType accountType;
    @JsonProperty("AccountCurrency")
    String accountCurrency;
    @JsonProperty("TaxReference")
    TaxReference taxReference;
    @JsonProperty("EntitlementOptionDefinition")
    String entitlementOptionDefinition;
    @JsonProperty("EntitlementOptionSetting")
    String entitlementOptionSetting;
    @JsonProperty("RestrictionOptionDefinition")
    String restrictionOptionDefinition;
    @JsonProperty("AestrictionOptionSetting")
    String aestrictionOptionSetting;
    @JsonProperty("Associations")
    String associations;
    @JsonProperty("AssociationType")
    String associationType;
    @JsonProperty("AssociationObligationOrEntitlement")
    String associationObligationOrEntitlement;
    @JsonProperty("AssociationReference")
    AssociationReference associationReference;
    @JsonProperty("LinkedAccounts")
    String linkedAccounts;
    @JsonProperty("LinkType")
    String linkType;
    @JsonProperty("AccountDetails")
    String accountDetails;
    @JsonProperty("PositionLimits")
    String positionLimits;
    @JsonProperty("PositionLimitType")
    String positionLimitType;
    @JsonProperty("PositionLimitSettings")
    String positionLimitSettings;
    @JsonProperty("PositionLimitValue")
    String positionLimitValue;
    @JsonProperty("DateType")
    String dateType;

}
