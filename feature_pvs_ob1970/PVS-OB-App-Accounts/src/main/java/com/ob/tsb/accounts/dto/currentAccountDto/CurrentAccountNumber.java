package com.ob.tsb.accounts.dto.currentAccountDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentAccountNumber {
    @JsonProperty("Account")
    public String account;
    @JsonProperty("IBAN")
    public String iBAN;
    @JsonProperty("BBAN")
    public String bBAN;
    @JsonProperty("UPIC")
    public String uPIC;
    @JsonProperty("ProprietaryIdentification")
    public String proprietaryIdentification;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("CostReferencePattern")
    public String costReferencePattern;
    @JsonProperty("Number")
    public String number;
}
