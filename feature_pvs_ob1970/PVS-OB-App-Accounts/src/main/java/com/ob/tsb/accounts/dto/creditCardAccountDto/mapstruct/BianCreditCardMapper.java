package com.ob.tsb.accounts.dto.creditCardAccountDto.mapstruct;

import com.ob.tsb.accounts.dto.creditCardAccountDto.CreditCardAccountResponse;
import com.ob.tsb.accounts.enums.AccountSubType;
import com.ob.tsb.accounts.enums.AccountType;
import com.ob.tsb.accounts.exception.CustomException;
import com.ob.tsb.accounts.response.AccountsResponseDataAccountInner;
import com.ob.tsb.accounts.response.AccountsResponseDataAccountInnerAccountInner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class BianCreditCardMapper {
    private static final Logger logger = LogManager.getLogger(BianCreditCardMapper.class);

    public static AccountsResponseDataAccountInner bianToOb(CreditCardAccountResponse bianResp) {

        AccountsResponseDataAccountInner account = new AccountsResponseDataAccountInner();
        try {
           // AccountsResponseDataAccountInnerAccountInner _mappedData = BianMapperCreditCard.INSTANCE.getAccountProduct(bianResp);
            AccountsResponseDataAccountInnerAccountInner _mappedData= new AccountsResponseDataAccountInnerAccountInner();
            account = BianMapperCreditCard.INSTANCE.getAccount(bianResp);
            account.setAccountType(AccountType.Personal.name());


            List<AccountsResponseDataAccountInnerAccountInner> creditCardAccountList = new ArrayList<>();
            creditCardAccountList.add(_mappedData);
            account.setAccount(creditCardAccountList);

            return account;

        } catch (Exception ex) {
            logger.error("Error while fetching accounts max attempt done: {}", ex.getMessage());
            throw new CustomException("451", "Failed to Map the object");
        }
    }

}
