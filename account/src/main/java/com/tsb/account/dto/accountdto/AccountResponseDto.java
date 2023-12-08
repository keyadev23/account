package com.tsb.account.dto.accountdto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseDto {
    @JsonProperty("CurrentAccountFacility")
    CurrentAccountFacility currentAccountFacility;
}
