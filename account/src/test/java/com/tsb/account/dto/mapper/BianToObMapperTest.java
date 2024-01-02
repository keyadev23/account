package com.tsb.account.dto.mapper;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsb.account.dto.accountdto.AccountResponseDto;
import com.tsb.account.dto.bianspecificresponsedto.BIANResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class BianToObMapperTest {
    private static final Logger logger = LogManager.getLogger(BianToObMapperTest.class);
    @Value("classpath:files/account-31820.json")
    Resource resourceFile;
    ModelMapper modelMapper;
    public static ObjectMapper objectMapper;




    @BeforeEach
    void setUp() {
        this.modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);
        objectMapper = new ObjectMapper();

    }

    @Test
    public void bianToObListMapper_test() throws IOException {
        File resource = resourceFile.getFile();
        byte[] byteArray = Files.readAllBytes(resource.toPath());
        String respStr = new String(byteArray);
        List<BIANResponse> bianResponse = objectMapper.readValue(respStr,
                new TypeReference<List<BIANResponse>>() {
                });
        List<AccountResponseDto> respList = BianToObMapper.bianToObListMapper(bianResponse, AccountResponseDto.class);
        assertThat(respList);
        assertEquals("31820", respList.get(0).getData().getAccount().get(0).getAccountId());
    }

}