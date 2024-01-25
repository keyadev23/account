package com.ob.tsb.accounts.dto.corporateCurrentAccountDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ob.tsb.accounts.dto.currentAccountDto.FromDateTime;
import com.ob.tsb.accounts.dto.currentAccountDto.ToDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PartyRoleValidityPeriod {
    @JsonProperty("FromDateTime")
    public FromDateTime fromDateTime;
    @JsonProperty("ToDateTime")
    public ToDateTime toDateTime;
    @JsonProperty("Datetimeperiod")
    public String datetimeperiod;
}
