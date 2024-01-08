package com.ob.tsb.beneficiaries.model.response.beneficiary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.annotation.processing.Generated;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen",
        date = "2021-03-22T23:26:32.308871+05:30[Asia/Kolkata]")
@Validated
public class BeneficiaryRespoonse {
    @JsonProperty("Data")
    public Data data;
    @JsonProperty("Links")
    public Links links;
    @JsonProperty("Meta")
    public Meta meta;
}
