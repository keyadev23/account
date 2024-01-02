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
public class AccountBalance {
    @JsonProperty("BalanceAmount")
    public BalanceAmount balanceAmount;
    @JsonProperty("BalanceType")
    public String balanceType;
    @JsonProperty("BalanceDate")
    public BalanceDate balanceDate;
    @JsonProperty("BalanceIndicator")
    public String balanceIndicator;
}
