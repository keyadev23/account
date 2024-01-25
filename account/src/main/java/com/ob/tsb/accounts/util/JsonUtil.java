package com.ob.tsb.accounts.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ob.tsb.accounts.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Throwable throwable) {
            log.info("Error in JsonUtil class in method toJson: {}", throwable.getMessage());
            throw new CustomException("451", "Something went wrong");
        }
    }

    public static <T> T toObject(String json, Class<T> type) {
        try {
            return objectMapper.readValue(json, type);
        } catch (Throwable throwable) {
            log.info("Error in JsonUtil class in method toObject: {}", throwable.getMessage());
            throw new CustomException("451", "Something went wrong");
        }
    }


}
