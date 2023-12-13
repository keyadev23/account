package com.tsb.account.model.response.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
@JsonInclude(value = JsonInclude.Include.NON_EMPTY,
        content = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public record LinkedAccount(
        @JsonProperty("SchemeName") String schemeName,
        @JsonProperty("Identification") String identification,
        @JsonProperty("Name") String name,
        @JsonProperty("SecondaryIdentification") String secondaryIdentification
) {
}
