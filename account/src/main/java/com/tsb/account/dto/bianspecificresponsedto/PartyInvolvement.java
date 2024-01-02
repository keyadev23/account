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
public class PartyInvolvement {
    @JsonProperty("PartyRoleType")
    public PartyRoleType partyRoleType;
    @JsonProperty("PartyRoleName")
    public PartyRoleName partyRoleName;
    @JsonProperty("PartyRoleValidityPeriod")
    public PartyRoleValidityPeriod partyRoleValidityPeriod;
    @JsonProperty("PartyInvolvementType")
    public String partyInvolvementType;
}
