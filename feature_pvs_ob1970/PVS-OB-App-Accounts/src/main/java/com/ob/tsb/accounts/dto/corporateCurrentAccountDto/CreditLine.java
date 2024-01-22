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
public class CreditLine {
    @JsonProperty("Included")
    public boolean included;
    @JsonProperty("Type")
    public String type;
    @JsonProperty("Amount")
    public Amount amount;
}
