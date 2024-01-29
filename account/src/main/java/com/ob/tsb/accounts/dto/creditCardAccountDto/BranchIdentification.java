package com.ob.tsb.accounts.dto.creditCardAccountDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BranchIdentification {
    @JsonProperty("IdentifierValue")
    public IdentifierValue identifierValue;
    @JsonProperty("IdentifierIssuingAuthority")
    public IdentifierIssuingAuthority identifierIssuingAuthority;
    @JsonProperty("IdentifierStartDate")
    public IdentifierStartDate identifierStartDate;
    @JsonProperty("IdentifierEndDate")
    public IdentifierEndDate identifierEndDate;
    @JsonProperty("Identifier")
    public String identifier;
}
