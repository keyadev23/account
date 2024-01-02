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
public class LimitFrequency {
    @JsonProperty("FrequencyCode")
    public String frequencyCode;
    @JsonProperty("FrequencyName")
    public FrequencyName frequencyName;
    @JsonProperty("FrequencyDefinition")
    public FrequencyDefinition frequencyDefinition;
}
