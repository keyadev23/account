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
public class RestrictionOptionSetting {
    @JsonProperty("AccountRestrictionIdentifier")
    public AccountRestrictionIdentifier accountRestrictionIdentifier;
    @JsonProperty("AccountRestrictionType")
    public AccountRestrictionType accountRestrictionType;
    @JsonProperty("AccountRestrictionDescription")
    public AccountRestrictionDescription accountRestrictionDescription;
    @JsonProperty("AccountRestrictionValidityPeriod")
    public AccountRestrictionValidityPeriod accountRestrictionValidityPeriod;
    @JsonProperty("AccountRestrictionStatus")
    public AccountRestrictionStatus accountRestrictionStatus;
    @JsonProperty("AccountRestrictionRegulator")
    public AccountRestrictionRegulator accountRestrictionRegulator;
}
