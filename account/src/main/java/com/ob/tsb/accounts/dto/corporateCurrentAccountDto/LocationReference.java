package com.ob.tsb.accounts.dto.corporateCurrentAccountDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationReference {
    @JsonProperty("NativePerson")
    public String nativePerson;
    @JsonProperty("System")
    public String system;
    @JsonProperty("DomiciledParty")
    public String domiciledParty;
    @JsonProperty("OperatingOrganisation")
    public String operatingOrganisation;
    @JsonProperty("Address")
    public String address;
    @JsonProperty("IssuedDocument")
    public String issuedDocument;
    @JsonProperty("Incoterms")
    public String incoterms;
    @JsonProperty("DepartureTransportParameters")
    public String departureTransportParameters;
    @JsonProperty("DestinationTransportParameters")
    public String destinationTransportParameters;
    @JsonProperty("InsuranceCertificate")
    public String insuranceCertificate;
    @JsonProperty("Party")
    public String party;
    @JsonProperty("RelatedExpiry")
    public String relatedExpiry;
    @JsonProperty("RelatedJurisdiction")
    public String relatedJurisdiction;
    @JsonProperty("Identification")
    public String identification;
    @JsonProperty("TaxableParty")
    public String taxableParty;
    @JsonProperty("RegisteredOrganisation")
    public String registeredOrganisation;
    @JsonProperty("RelatedTransport")
    public String relatedTransport;
    @JsonProperty("TimeZone")
    public String timeZone;
}
