package com.ob.tsb.accounts.dto.currentAccountDto.mapstruct;

import com.ob.tsb.accounts.dto.currentAccountDto.CurrentAccountResponse;
import com.ob.tsb.accounts.exception.CustomException;
import com.ob.tsb.accounts.response.accountResponse.Account;
import com.ob.tsb.accounts.response.accountResponse.AccountProduct;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class BianDtoMapper {
    private static final Logger logger = LogManager.getLogger(BianDtoMapper.class);

    public static Account bianToOb(CurrentAccountResponse bianResp) {

        Account account = new Account();
        try {

            AccountProduct _mappedData = BianMapper.INSTANCE.getAccountProduct(bianResp);
            account = BianMapper.INSTANCE.getAccount(bianResp);

            List<AccountProduct> currentAccountProductList = new ArrayList<>();
            currentAccountProductList.add(_mappedData);
            account.setAccountProductList(currentAccountProductList);

            return account;

        } catch (Exception ex) {
            logger.error("Error while fetching accounts max attempt done: {}", ex.getMessage());
            throw new CustomException("451", "Failed to Map the object");
        }
    }
}
