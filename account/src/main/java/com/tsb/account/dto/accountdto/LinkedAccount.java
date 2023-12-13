package com.tsb.account.dto.accountdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LinkedAccount{
    @JsonProperty("SchemeName") String schemeName;
    @JsonProperty("Identification") String identification;
    @JsonProperty("Name") String name;
    @JsonProperty("SecondaryIdentification") String secondaryIdentification;
}
