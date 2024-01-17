package com.ob.tsb.accounts.response;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.ob.tsb.accounts.response.AccountsResponseDataAccountInner;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * AccountsResponseData
 */

@JsonTypeName("AccountsResponse_Data")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-12T13:36:21.354557600+05:30[Asia/Calcutta]")
public class AccountsResponseData {

  @Valid
  private List<@Valid AccountsResponseDataAccountInner> account;

  public AccountsResponseData account(List<@Valid AccountsResponseDataAccountInner> account) {
    this.account = account;
    return this;
  }

  public AccountsResponseData addAccountItem(AccountsResponseDataAccountInner accountItem) {
    if (this.account == null) {
      this.account = new ArrayList<>();
    }
    this.account.add(accountItem);
    return this;
  }

  /**
   * Get account
   * @return account
  */
  @Valid 
  @Schema(name = "Account", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("Account")
  public List<@Valid AccountsResponseDataAccountInner> getAccount() {
    return account;
  }

  public void setAccount(List<@Valid AccountsResponseDataAccountInner> account) {
    this.account = account;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AccountsResponseData accountsResponseData = (AccountsResponseData) o;
    return Objects.equals(this.account, accountsResponseData.account);
  }

  @Override
  public int hashCode() {
    return Objects.hash(account);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AccountsResponseData {\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
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

