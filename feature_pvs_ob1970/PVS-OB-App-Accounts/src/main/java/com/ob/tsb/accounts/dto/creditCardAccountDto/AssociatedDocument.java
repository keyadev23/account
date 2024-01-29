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
public class AssociatedDocument {
    @JsonProperty("DocumentIdentification")
    public DocumentIdentification documentIdentification;
    @JsonProperty("DocumentVersion")
    public String documentVersion;
    @JsonProperty("DocumentType")
    public String documentType;
    @JsonProperty("DocumentStatus")
    public DocumentStatus documentStatus;
    @JsonProperty("DocumentDateTime")
    public DocumentDateTime documentDateTime;
    @JsonProperty("DocumentName")
    public String documentName;
    @JsonProperty("DocumentDateTimeType")
    public String documentDateTimeType;
    @JsonProperty("DocumentPurpose")
    public DocumentPurpose documentPurpose;
    @JsonProperty("DocumentFormat")
    public DocumentFormat documentFormat;
    @JsonProperty("DocumentSubject")
    public DocumentSubject documentSubject;
    @JsonProperty("DocumentDescription")
    public DocumentDescription documentDescription;
    @JsonProperty("DocumentValidityPeriod")
    public DocumentValidityPeriod documentValidityPeriod;
}
