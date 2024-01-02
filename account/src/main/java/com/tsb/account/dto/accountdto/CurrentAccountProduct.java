package com.tsb.account.dto.accountdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentAccountProduct {
    @JsonProperty("SchemeName")
    String schemeName;
    @JsonProperty("Identification")
    String identification;
    @JsonProperty("Name")
    String name;
    @JsonProperty("SecondaryIdentification")
    String secondaryIdentification;
}
