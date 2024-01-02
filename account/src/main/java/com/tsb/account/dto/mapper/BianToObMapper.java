package com.tsb.account.dto.mapper;

import com.tsb.account.dto.accountdto.*;
import com.tsb.account.dto.bianspecificresponsedto.BIANResponse;
import com.tsb.account.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class BianToObMapper {
    private static final Logger logger = LogManager.getLogger(BianToObMapper.class);
    private static ModelMapper modelMapper;

   /*private BianToObMapper(ModelMapper modelMapper){
        BianToObMapper.modelMapper = modelMapper;
    }*/

    public static List<AccountResponseDto> bianToObListMapper(List<BIANResponse> bianResp,
                                                              Class<AccountResponseDto> targetClass){
        modelMapper = new ModelMapper();
        try {
            return bianResp.stream()
                    .map(element -> {
                        modelMapper.getConfiguration()
                                .setMatchingStrategy(MatchingStrategies.LOOSE);
                        PropertyMap<BIANResponse, CurrentAccountProduct> linkedAccountMap = new PropertyMap<BIANResponse, CurrentAccountProduct>() {
                            protected void configure() {
                                map().setSchemeName(source.getCurrentAccountProductName().getName());
                                map().setIdentification(source.getCurrentAccountProductID().getIdentifierValue().getValue());
                                map().setName(source.getCurrentAccountProductID().getIdentifierIssuingAuthority()
                                        .getPartyReference().getPartyName().getName());
                                map().setSecondaryIdentification(source.getCurrentAccountSecondaryProductID().getIdentifierValue()
                                        .getValue());
                            }
                        };
                        modelMapper.addMappings(linkedAccountMap);
                        CurrentAccountProduct currentAccountProduct = modelMapper.map(element, CurrentAccountProduct.class);
                        logger.info("Linked Account Response {}", currentAccountProduct);
                        List<CurrentAccountProduct> currentAccountProductList = new ArrayList<>();
                        currentAccountProductList.add(currentAccountProduct);

                        PropertyMap<BIANResponse, Account> accountMap = new PropertyMap<BIANResponse, Account>() {
                            protected void configure() {
                                map().setAccountId(source.getCurrentAccountNumber()
                                        .getAccountIdentification().getIdentifierValue().getValue());
                                map().setStatus(source.getAccountDetails()
                                        .getAccountStatus().getAccountStatusType());
                                map().setStatusUpdateDateTime(source.getAccountDetails().getAccountStatus().getAccountStatus()
                                        .getStatusDateTime().getDateTimeContent());
                                map().setCurrency(source.getAccountCurrency().getAccountCurrency().getCurrencycode());
                                map().setAccountType(source.getCustomerReference().getPartyReference()
                                        .getPartyType());
                                map().setAccountSubType(source.getAccountType());
                                map().setNickname(source.getCustomerReference().getPartyReference()
                                        .getPartyName().getName());
                                map().setOpeningDate(source.getAccountDate().getDateTimeContent());
                            }
                        };
                        modelMapper.addMappings(accountMap);
                        Account account = modelMapper.map(element, Account.class);
                        account.setCurrentAccountProduct(currentAccountProductList);
                        logger.info("Account Response {}", account);
                        List<Account> accountList = new ArrayList<>();
                        accountList.add(account);
                        Data data = new Data();
                        data.setAccount(accountList);
                        AccountResponseDto accountResponseDto = new AccountResponseDto();
                        accountResponseDto.setData(data);

                        return accountResponseDto;
                    })
                    .collect(Collectors.toList());
        }catch (Exception ex){
            logger.error("Error while fetching accounts max attempt done: {}", ex.getMessage());
            throw new CustomException("451", "Failed to Map the object");
        }

    }

}
