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
public class LimitStatus {
    @JsonProperty("LimitStatus")
    public LimitStatus limitStatus;
    @JsonProperty("LimitStatusType")
    public String limitStatusType;
    @JsonProperty("StatusReason")
    public StatusReason statusReason;
    @JsonProperty("StatusDateTime")
    public StatusDateTime statusDateTime;
    @JsonProperty("StatusValidityPeriod")
    public StatusValidityPeriod statusValidityPeriod;
    @JsonProperty("StatusInvolvedParty")
    public StatusInvolvedParty statusInvolvedParty;
}
