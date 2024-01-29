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
public class IdentifierEndDate {
    @JsonProperty("DateTimeContent")
    public String dateTimeContent;
    @JsonProperty("TimeZoneCode")
    public String timeZoneCode;
    @JsonProperty("DaylightSavingIndicator")
    public String daylightSavingIndicator;
    @JsonProperty("Datetime")
    public String datetime;
}
