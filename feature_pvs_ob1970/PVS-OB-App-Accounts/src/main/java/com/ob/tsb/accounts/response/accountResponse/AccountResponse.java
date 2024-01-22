package com.ob.tsb.accounts.response.accountResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountResponse {

    @JsonIgnoreProperties("Data")
    private Data mData;
    @JsonIgnoreProperties("Links")
    private Links mLinks;
    @JsonIgnoreProperties("Meta")
    private Meta mMeta;


}
