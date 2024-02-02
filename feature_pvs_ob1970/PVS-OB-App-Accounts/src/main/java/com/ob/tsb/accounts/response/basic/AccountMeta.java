package com.ob.tsb.accounts.response.basic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"TotalPages"})
public class AccountMeta {

    @JsonProperty("TotalPages")
    private Integer totalPages;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("TotalPages")
    public Integer getTotalPages() {
        return totalPages;
    }

    @JsonProperty("TotalPages")
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public AccountMeta withTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
        return this;
    }

}
