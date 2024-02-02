package com.ob.tsb.accounts.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * AccountsResponseDataAccountInner
 */

@JsonTypeName("AccountsResponse_Data_Account_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-01-29T19:38:19.318642800+05:30[Asia/Calcutta]")
public class AccountsResponseDataAccountInner {

    private String accountId;

    private String status;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime statusUpdateDateTime;

    private String currency;

    private String accountType;

    private String accountSubType;

    private String nickname;

    private String openingDate;

    @Valid
    private List<@Valid AccountsResponseDataAccountInnerAccountInner> account;

    public AccountsResponseDataAccountInner accountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    /**
     * Get accountId
     *
     * @return accountId
     */

    @Schema(name = "AccountId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("AccountId")
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public AccountsResponseDataAccountInner status(String status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     */

    @Schema(name = "Status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AccountsResponseDataAccountInner statusUpdateDateTime(OffsetDateTime statusUpdateDateTime) {
        this.statusUpdateDateTime = statusUpdateDateTime;
        return this;
    }

    /**
     * Get statusUpdateDateTime
     *
     * @return statusUpdateDateTime
     */
    @Valid
    @Schema(name = "StatusUpdateDateTime", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("StatusUpdateDateTime")
    public OffsetDateTime getStatusUpdateDateTime() {
        return statusUpdateDateTime;
    }

    public void setStatusUpdateDateTime(OffsetDateTime statusUpdateDateTime) {
        this.statusUpdateDateTime = statusUpdateDateTime;
    }

    public AccountsResponseDataAccountInner currency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * Get currency
     *
     * @return currency
     */

    @Schema(name = "Currency", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("Currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public AccountsResponseDataAccountInner accountType(String accountType) {
        this.accountType = accountType;
        return this;
    }

    /**
     * Get accountType
     *
     * @return accountType
     */

    @Schema(name = "AccountType", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("AccountType")
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public AccountsResponseDataAccountInner accountSubType(String accountSubType) {
        this.accountSubType = accountSubType;
        return this;
    }

    /**
     * Get accountSubType
     *
     * @return accountSubType
     */

    @Schema(name = "AccountSubType", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("AccountSubType")
    public String getAccountSubType() {
        return accountSubType;
    }

    public void setAccountSubType(String accountSubType) {
        this.accountSubType = accountSubType;
    }

    public AccountsResponseDataAccountInner nickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    /**
     * Get nickname
     *
     * @return nickname
     */

    @Schema(name = "Nickname", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("Nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public AccountsResponseDataAccountInner openingDate(String openingDate) {
        this.openingDate = openingDate;
        return this;
    }

    /**
     * Get openingDate
     *
     * @return openingDate
     */

    @Schema(name = "OpeningDate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("OpeningDate")
    public String getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(String openingDate) {
        this.openingDate = openingDate;
    }

    public AccountsResponseDataAccountInner account(List<@Valid AccountsResponseDataAccountInnerAccountInner> account) {
        this.account = account;
        return this;
    }

    public AccountsResponseDataAccountInner addAccountItem(AccountsResponseDataAccountInnerAccountInner accountItem) {
        if (this.account == null) {
            this.account = new ArrayList<>();
        }
        this.account.add(accountItem);
        return this;
    }

    /**
     * Get account
     *
     * @return account
     */
    @Valid
    @Schema(name = "Account", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("Account")
    public List<@Valid AccountsResponseDataAccountInnerAccountInner> getAccount() {
        return account;
    }

    public void setAccount(List<@Valid AccountsResponseDataAccountInnerAccountInner> account) {
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
        AccountsResponseDataAccountInner accountsResponseDataAccountInner = (AccountsResponseDataAccountInner) o;
        return Objects.equals(this.accountId, accountsResponseDataAccountInner.accountId) &&
                Objects.equals(this.status, accountsResponseDataAccountInner.status) &&
                Objects.equals(this.statusUpdateDateTime, accountsResponseDataAccountInner.statusUpdateDateTime) &&
                Objects.equals(this.currency, accountsResponseDataAccountInner.currency) &&
                Objects.equals(this.accountType, accountsResponseDataAccountInner.accountType) &&
                Objects.equals(this.accountSubType, accountsResponseDataAccountInner.accountSubType) &&
                Objects.equals(this.nickname, accountsResponseDataAccountInner.nickname) &&
                Objects.equals(this.openingDate, accountsResponseDataAccountInner.openingDate) &&
                Objects.equals(this.account, accountsResponseDataAccountInner.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, status, statusUpdateDateTime, currency, accountType, accountSubType, nickname, openingDate, account);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountsResponseDataAccountInner {\n");
        sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    statusUpdateDateTime: ").append(toIndentedString(statusUpdateDateTime)).append("\n");
        sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
        sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
        sb.append("    accountSubType: ").append(toIndentedString(accountSubType)).append("\n");
        sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
        sb.append("    openingDate: ").append(toIndentedString(openingDate)).append("\n");
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

