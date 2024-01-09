package com.tsb.account.dto.mapstruct;

import com.tsb.account.dto.accountdto.Account;
import com.tsb.account.dto.accountdto.CurrentAccountProduct;
import com.tsb.account.dto.bianspecificresponsedto.BIANResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel="spring")
public interface BianMapper {

    BianMapper INSTANCE = Mappers.getMapper(BianMapper.class);
    @Mapping(source = "currentAccountProductName.name", target = "schemeName")
    @Mapping(source = "currentAccountProductID.identifierValue.value", target = "identification")
    @Mapping(source = "currentAccountProductID.identifierIssuingAuthority.partyReference.partyName.name", target = "name")
    @Mapping(source = "currentAccountSecondaryProductID.identifierValue.value", target = "secondaryIdentification")
    public CurrentAccountProduct getCurrentAccountProduct(BIANResponse _resp);

    @Mapping(source = "currentAccountNumber.accountIdentification.identifierValue.value", target = "accountId")
    @Mapping(source = "accountDetails.accountStatus.accountStatusType", target = "status")
    @Mapping(source = "accountDetails.accountStatus.accountStatus.statusDateTime.dateTimeContent", target = "statusUpdateDateTime")
    @Mapping(source = "accountCurrency.accountCurrency.currencycode", target = "currency")
    @Mapping(source = "customerReference.partyReference.partyType", target = "accountType")
    @Mapping(source = "accountType", target = "accountSubType")
    @Mapping(source = "customerReference.partyReference.partyName.name", target = "nickname")
    @Mapping(source = "accountDate.dateTimeContent", target = "openingDate")
    public Account getAccount(BIANResponse _resp);



}
