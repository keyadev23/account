package com.ob.tsb.accounts.response.basic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"Data", "Links", "Meta"})
public class AccountsResponseDTO {

    @JsonProperty("Data")
    private AccountData data;
    @JsonProperty("Links")
    private AccountLinks links;
    @JsonProperty("Meta")
    private AccountMeta meta;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Data")
    public AccountData getData() {
        return data;
    }

    @JsonProperty("Data")
    public void setData(AccountData data) {
        this.data = data;
    }

    public AccountsResponseDTO withData(AccountData data) {
        this.data = data;
        return this;
    }

    @JsonProperty("Links")
    public AccountLinks getLinks() {
        return links;
    }

    @JsonProperty("Links")
    public void setLinks(AccountLinks links) {
        this.links = links;
    }

    public AccountsResponseDTO withLinks(AccountLinks links) {
        this.links = links;
        return this;
    }

    @JsonProperty("Meta")
    public AccountMeta getMeta() {
        return meta;
    }

    @JsonProperty("Meta")
    public void setMeta(AccountMeta meta) {
        this.meta = meta;
    }

    public AccountsResponseDTO withMeta(AccountMeta meta) {
        this.meta = meta;
        return this;
    }

}
