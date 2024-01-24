package com.ob.tsb.accounts.dto.corporateCurrentAccountDto.mapstruct;

import com.ob.tsb.accounts.dto.corporateCurrentAccountDto.CorporateCurrentAccountResponse;
import com.ob.tsb.accounts.dto.currentAccountDto.CurrentAccountResponse;
import com.ob.tsb.accounts.response.AccountsResponseDataAccountInner;
import com.ob.tsb.accounts.response.AccountsResponseDataAccountInnerAccountInner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BianMapper {

    BianMapper INSTANCE = Mappers.getMapper(BianMapper.class);

    @Mapping(source = "corporateCurrentAccountProductMarketingStateID.scheme", target = "schemeName")
    @Mapping(source = "corporateCurrentAccountProductMarketingStateID.identification", target = "identification")
    @Mapping(source = "corporateCurrentAccountProductMarketingStateID.relatedPartyIdentification", target = "name")
    @Mapping(source = "corporateCurrentAccountSecondaryProductID.identification", target = "secondaryIdentification")
    public AccountsResponseDataAccountInnerAccountInner getAccountProduct(CorporateCurrentAccountResponse _resp);

    @Mapping(source = "accountidentification.accountIdentificationIn.identifierValue.value", target = "accountId")
    @Mapping(source = "accountDetails.status", target = "status")
    @Mapping(source = "accountDetails.liveDate", target = "statusUpdateDateTime")
    @Mapping(source = "accountbalance.balanceAmount.amountCurrency.currencycode", target = "currency")
    @Mapping(source = "currentAccountType.accountType", target = "accountType")
    @Mapping(source = "currentAccountType.accounttype", target = "accountSubType")
    @Mapping(source = "accountidentification.accountIdentificationIn.identifierIssuingAuthority.partyInvolvement.partyRoleName", target = "nickname")
    @Mapping(source = "accountDetails.openingDate", target = "openingDate")
    public AccountsResponseDataAccountInner getAccount(CorporateCurrentAccountResponse _resp);


}
