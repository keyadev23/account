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
public class Accountidentification {
    @JsonProperty("AccountIdentificationType")
    public String accountIdentificationType;
    @JsonProperty("AccountIdentification")
    public AccountIdentificationIn accountIdentification;
    @JsonProperty("Accountidentification")
    public String accountidentification;
}
