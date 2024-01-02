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
public class Associations {
    @JsonProperty("AccountInvolvementType")
    public String accountInvolvementType;
    @JsonProperty("AccountReference")
    public AccountReference accountReference;
    @JsonProperty("PartyReference")
    public PartyReference partyReference;
}
