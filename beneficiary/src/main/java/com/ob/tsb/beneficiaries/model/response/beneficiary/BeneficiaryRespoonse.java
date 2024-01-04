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
public class BeneficiaryRespoonse {
    @JsonProperty("Data")
    public Data data;
    @JsonProperty("Links")
    public Links links;
    @JsonProperty("Meta")
    public Meta meta;
}
