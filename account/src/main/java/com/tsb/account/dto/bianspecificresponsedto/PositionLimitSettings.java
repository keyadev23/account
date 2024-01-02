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
public class PositionLimitSettings {
    @JsonProperty("LimitType")
    public String limitType;
    @JsonProperty("LimitCurrency")
    public LimitCurrency limitCurrency;
    @JsonProperty("LimitValidityPeriod")
    public LimitValidityPeriod limitValidityPeriod;
    @JsonProperty("LimitAmount")
    public LimitAmount limitAmount;
    @JsonProperty("LimitStatus")
    public LimitStatus limitStatus;
    @JsonProperty("LimitRate")
    public LimitRate limitRate;
    @JsonProperty("LimitFrequency")
    public LimitFrequency limitFrequency;
    @JsonProperty("LimitIdentification")
    public LimitIdentification limitIdentification;
    @JsonProperty("LimitStartDatetime")
    public LimitStartDatetime limitStartDatetime;
    @JsonProperty("LimitCreditDebitIndicator")
    public String limitCreditDebitIndicator;
    @JsonProperty("LimitAmountType")
    public String limitAmountType;
}
