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
public class Beneficiary {
    @JsonProperty("AccountId")
    public String accountId;
    @JsonProperty("BeneficiaryId")
    public String beneficiaryId;
    @JsonProperty("Reference")
    public String reference;
    @JsonProperty("CreditorAccount")
    public CreditorAccount creditorAccount;
}
