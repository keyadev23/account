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
public class StatusDateTime {
    @JsonProperty("DateTimeContent")
    public String dateTimeContent;
    @JsonProperty("TimeZoneCode")
    public String timeZoneCode;
    @JsonProperty("DaylightSavingIndicator")
    public String daylightSavingIndicator;
}
