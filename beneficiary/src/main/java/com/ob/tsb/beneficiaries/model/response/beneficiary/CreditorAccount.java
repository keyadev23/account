package com.ob.tsb.beneficiaries.model.response.beneficiary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditorAccount {
    @JsonProperty("SchemeName")
    public String schemeName;
    @JsonProperty("Identification")
    public String identification;
    @JsonProperty("Name")
    public String name;
}
