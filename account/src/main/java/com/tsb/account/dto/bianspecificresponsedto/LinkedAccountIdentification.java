package com.tsb.account.dto.bianspecificresponsedto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tsb.account.dto.bianspecificresponsedto.AccountIdentification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LinkedAccountIdentification {
    @JsonProperty("AccountIdentificationType")
    public String accountIdentificationType;
    @JsonProperty("AccountIdentification")
    public AccountIdentification accountIdentification;
}
