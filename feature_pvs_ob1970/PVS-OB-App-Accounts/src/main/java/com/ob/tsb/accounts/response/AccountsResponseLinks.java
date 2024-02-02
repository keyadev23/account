package com.ob.tsb.accounts.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

import java.util.Objects;

/**
 * AccountsResponseLinks
 */

@JsonTypeName("AccountsResponse_Links")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-29T19:38:19.318642800+05:30[Asia/Calcutta]")
public class AccountsResponseLinks {

    private String self;

    public AccountsResponseLinks self(String self) {
        this.self = self;
        return this;
    }

    /**
     * Get self
     *
     * @return self
     */

    @Schema(name = "Self", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("Self")
    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountsResponseLinks accountsResponseLinks = (AccountsResponseLinks) o;
        return Objects.equals(this.self, accountsResponseLinks.self);
    }

    @Override
    public int hashCode() {
        return Objects.hash(self);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountsResponseLinks {\n");
        sb.append("    self: ").append(toIndentedString(self)).append("\n");
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

