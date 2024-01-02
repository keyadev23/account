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
public class AccountStatus {
    @JsonProperty("AccountStatus")
    public AccountStatus accountStatus;
    @JsonProperty("AccountStatusType")
    public String accountStatusType;
    @JsonProperty("StatusReason")
    public StatusReason statusReason;
    @JsonProperty("StatusDateTime")
    public StatusDateTime statusDateTime;
    @JsonProperty("StatusValidityPeriod")
    public StatusValidityPeriod statusValidityPeriod;
    @JsonProperty("StatusInvolvedParty")
    public StatusInvolvedParty statusInvolvedParty;
}
