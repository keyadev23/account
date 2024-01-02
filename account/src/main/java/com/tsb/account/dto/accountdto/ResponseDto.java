package com.tsb.account.dto.accountdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;
@lombok.Data
@NoArgsConstructor(force = true)
@JsonInclude(value = JsonInclude.Include.NON_EMPTY,
        content = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseDto {
    @JsonProperty("Data")
    Data data;
}
