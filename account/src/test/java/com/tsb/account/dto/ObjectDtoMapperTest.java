package com.tsb.account.dto;

import com.tsb.account.dto.accountdto.AccountResponseDto;
import com.tsb.account.model.response.account.AccountResponse;
import com.tsb.account.model.response.account.CurrentAccountFacility;
import com.tsb.account.model.response.account.Data;
import com.tsb.account.util.JsonUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObjectDtoMapperTest {

    @Mock
    ObjectDtoMapper objectDtoMapper;
    ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        this.modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void dtoMapper(){
        AccountResponseDto respObj = new AccountResponseDto();
        AccountResponse accountObj= new AccountResponse(Data.builder().build());
        try(MockedStatic<JsonUtil> utilities = Mockito.mockStatic(JsonUtil.class)){
           utilities.when(() -> JsonUtil.toObject(JsonUtil.toJson(accountObj), AccountResponseDto.class)).thenReturn(respObj);
        }
        assertInstanceOf(AccountResponseDto.class,JsonUtil.toObject(JsonUtil.toJson(accountObj), AccountResponseDto.class));

    }

    @Test
    void listMapper() {
        List<AccountResponseDto> respObj = new ArrayList<>();
        AccountResponse accountObj= new AccountResponse(Data.builder().build());
        List<AccountResponse> accountObjList = Arrays.asList(accountObj);
        respObj=accountObjList.stream()
                .map(e -> modelMapper.map(e, AccountResponseDto.class)).toList();

        assertInstanceOf(AccountResponseDto.class, respObj.get(0));


    }

    @Test
    void dtoMapper_test() throws Exception{
        AccountResponseDto respObj = new AccountResponseDto();
        AccountResponse accountObj= new AccountResponse(Data.builder().build());
        try(MockedStatic<ObjectDtoMapper> utilities = Mockito.mockStatic(ObjectDtoMapper.class)){
            utilities.when(() -> ObjectDtoMapper.dtoMapper(JsonUtil.toJson(accountObj), AccountResponseDto.class)).thenReturn(respObj);
            assertInstanceOf(AccountResponseDto.class,ObjectDtoMapper.dtoMapper(JsonUtil.toJson(accountObj), AccountResponseDto.class));
        }


    }
    @Test
    void listMapper_test() {
        List<AccountResponseDto> respObj = new ArrayList<>();
        AccountResponse accountObj= new AccountResponse(Data.builder().build());
        List<AccountResponse> accountObjList = Arrays.asList(accountObj);
        try(MockedStatic<ObjectDtoMapper> utilities = Mockito.mockStatic(ObjectDtoMapper.class)) {
            utilities.when(() ->ObjectDtoMapper.listMapper(accountObjList, AccountResponseDto.class)).thenReturn(respObj);

        }

    }
}
