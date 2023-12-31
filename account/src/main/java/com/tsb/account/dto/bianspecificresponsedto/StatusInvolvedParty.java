package com.tsb.account.dto.bianspecificresponsedto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tsb.account.dto.bianspecificresponsedto.PartyInvolvement;
import com.tsb.account.dto.bianspecificresponsedto.PartyReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusInvolvedParty {
    @JsonProperty("PartyReference")
    public PartyReference partyReference;
    @JsonProperty("PartyInvolvement")
    public PartyInvolvement partyInvolvement;
}
