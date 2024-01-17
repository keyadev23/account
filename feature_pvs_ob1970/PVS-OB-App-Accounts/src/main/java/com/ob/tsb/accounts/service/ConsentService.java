package com.ob.tsb.accounts.service;

import java.util.List;

public interface ConsentService {

    boolean validateConsents(List<String> consents, String token);
}
