package com.ob.tsb.accounts.dto.corporateCurrentAccountDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ob.tsb.accounts.dto.currentAccountDto.BalanceAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountbalanceDetails {
    @JsonProperty("BalanceAmount")
    public BalanceAmount balanceAmount;
    @JsonProperty("BalanceType")
    public String balanceType;
    @JsonProperty("BalanceDate")
    public String balanceDate;
    @JsonProperty("BalanceIndicator")
    public String balanceIndicator;
    @JsonProperty("Accountbalance")
    public String accountbalance;
}
