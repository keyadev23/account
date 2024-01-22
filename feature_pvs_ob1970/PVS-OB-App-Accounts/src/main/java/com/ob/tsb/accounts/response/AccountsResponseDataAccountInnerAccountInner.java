package com.ob.tsb.accounts.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;

import java.util.Objects;

/**
 * AccountsResponseDataAccountInnerAccountInner
 */

@JsonTypeName("AccountsResponse_Data_Account_inner_Account_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-12T13:36:21.354557600+05:30[Asia/Calcutta]")
public class AccountsResponseDataAccountInnerAccountInner {

    private String schemeName;

    private String identification;

    private String name;

    private String secondaryIdentification;

    public AccountsResponseDataAccountInnerAccountInner schemeName(String schemeName) {
        this.schemeName = schemeName;
        return this;
    }

    /**
     * Get schemeName
     *
     * @return schemeName
     */

    @Schema(name = "SchemeName", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("SchemeName")
    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public AccountsResponseDataAccountInnerAccountInner identification(String identification) {
        this.identification = identification;
        return this;
    }

    /**
     * Get identification
     *
     * @return identification
     */

    @Schema(name = "Identification", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("Identification")
    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public AccountsResponseDataAccountInnerAccountInner name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     */

    @Schema(name = "Name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountsResponseDataAccountInnerAccountInner secondaryIdentification(String secondaryIdentification) {
        this.secondaryIdentification = secondaryIdentification;
        return this;
    }

    /**
     * Get secondaryIdentification
     *
     * @return secondaryIdentification
     */

    @Schema(name = "SecondaryIdentification", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("SecondaryIdentification")
    public String getSecondaryIdentification() {
        return secondaryIdentification;
    }

    public void setSecondaryIdentification(String secondaryIdentification) {
        this.secondaryIdentification = secondaryIdentification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountsResponseDataAccountInnerAccountInner accountsResponseDataAccountInnerAccountInner = (AccountsResponseDataAccountInnerAccountInner) o;
        return Objects.equals(this.schemeName, accountsResponseDataAccountInnerAccountInner.schemeName) &&
                Objects.equals(this.identification, accountsResponseDataAccountInnerAccountInner.identification) &&
                Objects.equals(this.name, accountsResponseDataAccountInnerAccountInner.name) &&
                Objects.equals(this.secondaryIdentification, accountsResponseDataAccountInnerAccountInner.secondaryIdentification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(schemeName, identification, name, secondaryIdentification);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountsResponseDataAccountInnerAccountInner {\n");
        sb.append("    schemeName: ").append(toIndentedString(schemeName)).append("\n");
        sb.append("    identification: ").append(toIndentedString(identification)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    secondaryIdentification: ").append(toIndentedString(secondaryIdentification)).append("\n");
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

