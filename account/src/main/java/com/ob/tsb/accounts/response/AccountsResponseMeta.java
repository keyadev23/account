package com.ob.tsb.accounts.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

import java.util.Objects;

/**
 * AccountsResponseMeta
 */

@JsonTypeName("AccountsResponse_Meta")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-12T13:36:21.354557600+05:30[Asia/Calcutta]")
public class AccountsResponseMeta {

    private Integer totalPages;

    public AccountsResponseMeta totalPages(Integer totalPages) {
        this.totalPages = totalPages;
        return this;
    }

    /**
     * Get totalPages
     *
     * @return totalPages
     */

    @Schema(name = "TotalPages", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("TotalPages")
    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountsResponseMeta accountsResponseMeta = (AccountsResponseMeta) o;
        return Objects.equals(this.totalPages, accountsResponseMeta.totalPages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalPages);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountsResponseMeta {\n");
        sb.append("    totalPages: ").append(toIndentedString(totalPages)).append("\n");
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

