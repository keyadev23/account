package com.tsb.account.dto.mapstruct;

import com.tsb.account.dto.accountdto.Account;
import com.tsb.account.dto.accountdto.AccountResponseDto;
import com.tsb.account.dto.accountdto.CurrentAccountProduct;
import com.tsb.account.dto.accountdto.Data;
import com.tsb.account.dto.bianspecificresponsedto.BIANResponse;
import com.tsb.account.dto.mapper.BianToObMapper;
import com.tsb.account.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BianDtoMapper {
    private static final Logger logger = LogManager.getLogger(BianDtoMapper.class);
    public static List<AccountResponseDto> bianToOb(List<BIANResponse> bianRespList){


        try {
            return bianRespList.stream()
                    .map(element -> {

                            AccountResponseDto respnseDto = new AccountResponseDto();

                            CurrentAccountProduct _mappedData=BianMapper.INSTANCE.getCurrentAccountProduct(element);
                            Account _accountMappedData = BianMapper.INSTANCE.getAccount(element);

                            List<CurrentAccountProduct> currentAccountProductList= new ArrayList<>();
                            currentAccountProductList.add(_mappedData);
                            _accountMappedData.setCurrentAccountProduct(currentAccountProductList);

                            List<Account> accountList = new ArrayList<>();
                            accountList.add(_accountMappedData);

                            Data data = new Data();
                            data.setAccount(accountList);

                            AccountResponseDto _accntRespDto = new AccountResponseDto();
                            _accntRespDto.setData(data);

                            return _accntRespDto;
                    })
                    .collect(Collectors.toList());
        }catch (Exception ex){
            logger.error("Error while fetching accounts max attempt done: {}", ex.getMessage());
            throw new CustomException("451", "Failed to Map the object");
        }
    }
}
