package com.ob.tsb.accounts.dto.corporateCurrentAccountDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BankBranchLocationReference {
    @JsonProperty("BranchIdentification")
    public BranchIdentification branchIdentification;
    @JsonProperty("BranchLegalEntityIdentification")
    public BranchLegalEntityIdentification branchLegalEntityIdentification;
    @JsonProperty("BranchAddress")
    public BranchAddress branchAddress;
    @JsonProperty("BranchName")
    public String branchName;
}
