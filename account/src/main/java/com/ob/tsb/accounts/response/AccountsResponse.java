package com.ob.tsb.accounts.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import java.util.Objects;

/**
 * AccountsResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-12T13:36:21.354557600+05:30[Asia/Calcutta]")
public class AccountsResponse {

    private AccountsResponseData data;

    private AccountsResponseLinks links;

    private AccountsResponseMeta meta;

    public AccountsResponse data(AccountsResponseData data) {
        this.data = data;
        return this;
    }

    /**
     * Get data
     *
     * @return data
     */
    @Valid
    @Schema(name = "Data", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("Data")
    public AccountsResponseData getData() {
        return data;
    }

    public void setData(AccountsResponseData data) {
        this.data = data;
    }

    public AccountsResponse links(AccountsResponseLinks links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     *
     * @return links
     */
    @Valid
    @Schema(name = "Links", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("Links")
    public AccountsResponseLinks getLinks() {
        return links;
    }

    public void setLinks(AccountsResponseLinks links) {
        this.links = links;
    }

    public AccountsResponse meta(AccountsResponseMeta meta) {
        this.meta = meta;
        return this;
    }

    /**
     * Get meta
     *
     * @return meta
     */
    @Valid
    @Schema(name = "Meta", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("Meta")
    public AccountsResponseMeta getMeta() {
        return meta;
    }

    public void setMeta(AccountsResponseMeta meta) {
        this.meta = meta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountsResponse accountsResponse = (AccountsResponse) o;
        return Objects.equals(this.data, accountsResponse.data) &&
                Objects.equals(this.links, accountsResponse.links) &&
                Objects.equals(this.meta, accountsResponse.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, links, meta);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountsResponse {\n");
        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("    links: ").append(toIndentedString(links)).append("\n");
        sb.append("    meta: ").append(toIndentedString(meta)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

