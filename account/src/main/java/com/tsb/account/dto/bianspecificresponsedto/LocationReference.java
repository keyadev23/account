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
public class LocationReference {
    @JsonProperty("LocationDescription")
    public LocationDescription locationDescription;
    @JsonProperty("LocationDateTime")
    public LocationDateTime locationDateTime;
    @JsonProperty("LocationStatus")
    public LocationStatus locationStatus;
    @JsonProperty("LocationType")
    public String locationType;
    @JsonProperty("LocationZoningType")
    public LocationZoningType locationZoningType;
    @JsonProperty("LocationNeighborhoodType")
    public LocationNeighborhoodType locationNeighborhoodType;
    @JsonProperty("LocationConstructionType")
    public LocationConstructionType locationConstructionType;
    @JsonProperty("LocationOccupancyType")
    public LocationOccupancyType locationOccupancyType;
    @JsonProperty("LocationValue")
    public LocationValue locationValue;
    @JsonProperty("LocationCapacity")
    public LocationCapacity locationCapacity;
    @JsonProperty("LocationIdentification")
    public LocationIdentification locationIdentification;
    @JsonProperty("LocationAddress")
    public String locationAddress;
    @JsonProperty("LocationName")
    public LocationName locationName;
    @JsonProperty("LocationTimeZone")
    public LocationTimeZone locationTimeZone;
}
