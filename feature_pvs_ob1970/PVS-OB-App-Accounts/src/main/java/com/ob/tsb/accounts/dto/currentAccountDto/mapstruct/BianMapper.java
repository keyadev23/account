package com.ob.tsb.accounts.dto.currentAccountDto.mapstruct;

import com.ob.tsb.accounts.dto.currentAccountDto.CurrentAccountResponse;
import com.ob.tsb.accounts.response.accountResponse.Account;
import com.ob.tsb.accounts.response.accountResponse.AccountProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BianMapper {

    BianMapper INSTANCE = Mappers.getMapper(BianMapper.class);

    @Mapping(source = "currentAccountProductName", target = "schemeName")
    @Mapping(source = "currentAccountProductID.identification", target = "identification")
    @Mapping(source = "currentAccountProductID.relatedPartyIdentification", target = "name")
    @Mapping(source = "currentAccountSecondaryProductID.identification", target = "secondaryIdentification")
    public AccountProduct getAccountProduct(CurrentAccountResponse _resp);

    @Mapping(source = "accountidentification.accountIdentificationIn.identifierValue.value", target = "accountId")
    @Mapping(source = "accountDetails.status", target = "status")
    @Mapping(source = "accountDetails.liveDate", target = "statusUpdateDateTime")
    @Mapping(source = "accountbalance.balanceAmount.amountCurrency.currencycode", target = "currency")
    @Mapping(source = "currentAccountType.accountType", target = "accountType")
    @Mapping(source = "currentAccountType.accounttype", target = "accountSubType")
    @Mapping(source = "accountidentification.accountIdentificationIn.identifierIssuingAuthority.partyInvolvement.partyRoleName", target = "nickname")
    @Mapping(source = "accountDetails.openingDate", target = "openingDate")
    public Account getAccount(CurrentAccountResponse _resp);


}
