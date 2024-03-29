package com.ob.tsb.accounts.response.basic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"Self"})
public class AccountLinks {

    @JsonProperty("Self")
    private String self;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Self")
    public String getSelf() {
        return self;
    }

    @JsonProperty("Self")
    public void setSelf(String self) {
        this.self = self;
    }

    public AccountLinks withSelf(String self) {
        this.self = self;
        return this;
    }

}
