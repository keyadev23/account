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
public class LimitRate {
    @JsonProperty("RateValue")
    public RateValue rateValue;
    @JsonProperty("RateUnit")
    public RateUnit rateUnit;
    @JsonProperty("RatePeriod")
    public RatePeriod ratePeriod;
    @JsonProperty("RateCapitalUnit")
    public RateCapitalUnit rateCapitalUnit;
}
