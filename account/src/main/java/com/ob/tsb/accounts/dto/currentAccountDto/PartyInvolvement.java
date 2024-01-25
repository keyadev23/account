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
public class PartyInvolvement {
    @JsonProperty("PartyRoleType")
    public PartyRoleType partyRoleType;
    @JsonProperty("PartyRoleName")
    public String partyRoleName;
    @JsonProperty("PartyRoleValidityPeriod")
    public PartyRoleValidityPeriod partyRoleValidityPeriod;
    @JsonProperty("PartyInvolvementType")
    public String partyInvolvementType;
}
