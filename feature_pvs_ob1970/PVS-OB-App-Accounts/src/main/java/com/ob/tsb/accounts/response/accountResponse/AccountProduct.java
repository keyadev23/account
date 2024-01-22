package com.ob.tsb.accounts.response.accountResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountProduct {

    @JsonIgnoreProperties("Identification")
    private String identification;
    @JsonIgnoreProperties("Name")
    private String name;
    @JsonIgnoreProperties("SchemeName")
    private String schemeName;
    @JsonIgnoreProperties("SecondaryIdentification")
    private String secondaryIdentification;

}
