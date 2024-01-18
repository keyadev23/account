package com.ob.tsb.accounts.dto.consentDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsentResponse {
    @JsonProperty("Data")
    public Data data;
    @JsonProperty("Risk")
    public Risk risk;
    @JsonProperty("Links")
    public Links links;
    @JsonProperty("Meta")
    public Meta meta;
}
