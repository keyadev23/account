package com.ob.tsb.accounts.dto.currentAccountDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RestrictionOptionSetting {
    @JsonProperty("Account")
    public String account;
    @JsonProperty("RestrictionType")
    public String restrictionType;
    @JsonProperty("ValidityPeriod")
    public String validityPeriod;
}
