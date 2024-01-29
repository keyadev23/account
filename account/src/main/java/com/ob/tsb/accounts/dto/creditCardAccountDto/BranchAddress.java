package com.ob.tsb.accounts.dto.creditCardAccountDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BranchAddress {
    @JsonProperty("AddressType")
    public String addressType;
    @JsonProperty("LocationReference")
    public LocationReference locationReference;
    @JsonProperty("Address")
    public String address;
}
