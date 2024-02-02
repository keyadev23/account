package com.ob.tsb.accounts.util;

public enum ConsentStatus {

    AWAITING_AUTHORISATION("AwaitingAuthorisation"),
    REJECTED("Rejected"),
    AUTHORISED("Authorised");

    public final String status;

    ConsentStatus(String status) {
        this.status = status;
    }
}
