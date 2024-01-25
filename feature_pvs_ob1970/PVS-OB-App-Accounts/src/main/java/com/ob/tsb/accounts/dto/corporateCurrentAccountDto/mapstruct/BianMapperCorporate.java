package com.ob.tsb.accounts.dto.corporateCurrentAccountDto.mapstruct;

import com.ob.tsb.accounts.dto.corporateCurrentAccountDto.CorporateCurrentAccountResponse;
import com.ob.tsb.accounts.response.AccountsResponseDataAccountInner;
import com.ob.tsb.accounts.response.AccountsResponseDataAccountInnerAccountInner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BianMapperCorporate {

    BianMapperCorporate INSTANCE = Mappers.getMapper(BianMapperCorporate.class);

    @Mapping(source = "corporateCurrentAccountProductMarketingStateID.scheme", target = "schemeName")
    @Mapping(source = "corporateCurrentAccountProductMarketingStateID.identification", target = "identification")
    @Mapping(source = "corporateCurrentAccountProductMarketingStateID.relatedPartyIdentification", target = "name")
    @Mapping(source = "corporateCurrentAccountSecondaryProductID.identification", target = "secondaryIdentification")
    public AccountsResponseDataAccountInnerAccountInner getAccountProduct(CorporateCurrentAccountResponse _resp);

    @Mapping(source = "accountidentification.accountIdentification.identifierValue.value", target = "accountId")
    @Mapping(source = "accountDetails.status", target = "status")
    @Mapping(source = "accountDetails.liveDate", target = "statusUpdateDateTime")
    @Mapping(source = "accountbalance.balanceAmount.amountCurrency.currencycode", target = "currency")
    @Mapping(source = "corporateCurrentAccountType.accounttype", target = "accountSubType")
    @Mapping(source = "accountidentification.accountIdentification.identifierIssuingAuthority.partyInvolvement.partyRoleName", target = "nickname")
    @Mapping(source = "accountDetails.openingDate", target = "openingDate")
    public AccountsResponseDataAccountInner getAccount(CorporateCurrentAccountResponse _resp);


}
