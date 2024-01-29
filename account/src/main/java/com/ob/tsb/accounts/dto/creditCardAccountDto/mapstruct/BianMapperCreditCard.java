package com.ob.tsb.accounts.dto.creditCardAccountDto.mapstruct;

import com.ob.tsb.accounts.dto.creditCardAccountDto.CreditCardAccountResponse;
import com.ob.tsb.accounts.response.AccountsResponseDataAccountInner;
import com.ob.tsb.accounts.response.AccountsResponseDataAccountInnerAccountInner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BianMapperCreditCard {

    BianMapperCreditCard INSTANCE = Mappers.getMapper(BianMapperCreditCard.class);

    @Mapping(source = "creditCardProductID.scheme", target = "schemeName")
    @Mapping(source = "creditCardProductID.identification", target = "identification")
    @Mapping(source = "creditCardProductID.relatedPartyIdentification", target = "name")
    @Mapping(source = "creditCardProductMarketingStateID.identification", target = "secondaryIdentification")
    public AccountsResponseDataAccountInnerAccountInner getAccountProduct(CreditCardAccountResponse _resp);

    @Mapping(source = "accountidentification.accountIdentification.identifierValue.value", target = "accountId")
    @Mapping(source = "accountDetails.status", target = "status")
    @Mapping(source = "accountDetails.liveDate", target = "statusUpdateDateTime")
    @Mapping(source = "accountbalance.balanceAmount.amountCurrency", target = "currency")
    @Mapping(source = "accountidentification.accountIdentification.identifierIssuingAuthority.partyInvolvement.partyRoleName", target = "nickname")
    @Mapping(source = "accountDetails.openingDate", target = "openingDate")
    public AccountsResponseDataAccountInner getAccount(CreditCardAccountResponse _resp);


}
