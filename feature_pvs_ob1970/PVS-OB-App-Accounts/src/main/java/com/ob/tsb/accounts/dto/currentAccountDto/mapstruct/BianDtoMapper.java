package com.ob.tsb.accounts.dto.currentAccountDto.mapstruct;

import com.ob.tsb.accounts.dto.currentAccountDto.CurrentAccountResponse;
import com.ob.tsb.accounts.enums.AccountSubType;
import com.ob.tsb.accounts.enums.AccountType;
import com.ob.tsb.accounts.exception.CustomException;
import com.ob.tsb.accounts.response.AccountsResponseDataAccountInner;
import com.ob.tsb.accounts.response.AccountsResponseDataAccountInnerAccountInner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class BianDtoMapper {
    private static final Logger logger = LogManager.getLogger(BianDtoMapper.class);

    public static AccountsResponseDataAccountInner bianToOb(CurrentAccountResponse bianResp) {

        AccountsResponseDataAccountInner account = new AccountsResponseDataAccountInner();
        try {

            AccountsResponseDataAccountInnerAccountInner _mappedData = BianMapper.INSTANCE.getAccountProduct(bianResp);
            account = BianMapper.INSTANCE.getAccount(bianResp);
            account.setAccountType(AccountType.Personal.name());
            account.setAccountSubType(AccountSubType.CurrentAccount.name());

            List<AccountsResponseDataAccountInnerAccountInner> currentAccountProductList = new ArrayList<>();
            currentAccountProductList.add(_mappedData);
            account.setAccount(currentAccountProductList);

            return account;

        } catch (Exception ex) {
            logger.error("Error while fetching accounts max attempt done: {}", ex.getMessage());
            throw new CustomException("451", "Failed to Map the object");
        }
    }
}
