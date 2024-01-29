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
public class DocumentStatus {
    @JsonProperty("StatusReason")
    public StatusReason statusReason;
    @JsonProperty("StatusDateTime")
    public StatusDateTime statusDateTime;
    @JsonProperty("StatusValidityPeriod")
    public StatusValidityPeriod statusValidityPeriod;
    @JsonProperty("StatusInvolvedParty")
    public StatusInvolvedParty statusInvolvedParty;
    @JsonProperty("Status")
    public String status;

}
