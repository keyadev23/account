package com.ob.tsb.accounts.dto.consentDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    @JsonProperty("ConsentId")
    public String consentId;
    @JsonProperty("Status")
    public String status;
    @JsonProperty("StatusUpdateDateTime")
    public Date statusUpdateDateTime;
    @JsonProperty("CreationDateTime")
    public Date creationDateTime;
    @JsonProperty("Permissions")
    public List<String> permissions;
    @JsonProperty("Accounts")
    public List<String> accounts;
    @JsonProperty("ExpirationDateTime")
    public Date expirationDateTime;
    @JsonProperty("TransactionFromDateTime")
    public Date transactionFromDateTime;
    @JsonProperty("TransactionToDateTime")
    public Date transactionToDateTime;
}
