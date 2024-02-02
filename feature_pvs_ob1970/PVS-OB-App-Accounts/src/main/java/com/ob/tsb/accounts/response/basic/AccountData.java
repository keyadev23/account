package com.ob.tsb.accounts.response.basic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"Account"})
public class AccountData {

    @JsonProperty("Account")
    private List<Account> account = new ArrayList<Account>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Account")
    public List<Account> getAccount() {
        return account;
    }

    @JsonProperty("Account")
    public void setAccount(List<Account> account) {
        this.account = account;
    }

    public AccountData withAccount(List<Account> account) {
        this.account = account;
        return this;
    }


}
