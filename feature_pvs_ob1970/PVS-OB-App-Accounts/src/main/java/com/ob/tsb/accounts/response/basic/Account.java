package com.ob.tsb.accounts.response.basic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"AccountId", "Status", "StatusUpdateDateTime", "Currency", "AccountType", "AccountSubType",
        "Nickname"})
public class Account {

    @JsonProperty("AccountId")
    private String accountId;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("StatusUpdateDateTime")
    private String statusUpdateDateTime;
    @JsonProperty("Currency")
    private String currency;
    @JsonProperty("AccountType")
    private String accountType;
    @JsonProperty("AccountSubType")
    private String accountSubType;
    @JsonProperty("Nickname")
    private String nickname;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("AccountId")
    public String getAccountId() {
        return accountId;
    }

    @JsonProperty("AccountId")
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Account withAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    @JsonProperty("Status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(String status) {
        this.status = status;
    }

    public Account withStatus(String status) {
        this.status = status;
        return this;
    }

    @JsonProperty("StatusUpdateDateTime")
    public String getStatusUpdateDateTime() {
        return statusUpdateDateTime;
    }

    @JsonProperty("StatusUpdateDateTime")
    public void setStatusUpdateDateTime(String statusUpdateDateTime) {
        this.statusUpdateDateTime = statusUpdateDateTime;
    }

    public Account withStatusUpdateDateTime(String statusUpdateDateTime) {
        this.statusUpdateDateTime = statusUpdateDateTime;
        return this;
    }

    @JsonProperty("Currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("Currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Account withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    @JsonProperty("AccountType")
    public String getAccountType() {
        return accountType;
    }

    @JsonProperty("AccountType")
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Account withAccountType(String accountType) {
        this.accountType = accountType;
        return this;
    }

    @JsonProperty("AccountSubType")
    public String getAccountSubType() {
        return accountSubType;
    }

    @JsonProperty("AccountSubType")
    public void setAccountSubType(String accountSubType) {
        this.accountSubType = accountSubType;
    }

    public Account withAccountSubType(String accountSubType) {
        this.accountSubType = accountSubType;
        return this;
    }

    @JsonProperty("Nickname")
    public String getNickname() {
        return nickname;
    }

    @JsonProperty("Nickname")
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Account withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

}
