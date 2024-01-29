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
public class StatementReport {
    @JsonProperty("ReportType")
    public String reportType;
    @JsonProperty("ReportValidityPeriod")
    public ReportValidityPeriod reportValidityPeriod;
    @JsonProperty("ReportVersion")
    public String reportVersion;
    @JsonProperty("ReportDateTime")
    public ReportDateTime reportDateTime;
    @JsonProperty("ReportFormat")
    public ReportFormat reportFormat;

}
