package com.tsb.account.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsb.account.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JsonUtil {

    private static final Logger log = LogManager.getLogger(JsonUtil.class);
    private static ObjectMapper objectMapper;

    @Autowired
    public static void setObjectMapper(ObjectMapper objectMapper) {
        JsonUtil.objectMapper = objectMapper;
    }

    public static String toJson(Object object) {
        try {
            setObjectMapper(new ObjectMapper());
            return objectMapper.writeValueAsString(object);
        } catch (Exception ex) {
            log.info("Error in JsonUtil class in method toJson: {}", ex.getMessage());
            throw new CustomException("451", "Something went wrong");
        }
    }

    public static <T> List<T> toObjectOfList(String json, TypeReference<List<T>> type) {
        try {
            return objectMapper.readValue(json, type);
        } catch (Exception ex) {
            log.info("Error in JsonUtil class in method toObject: {}", ex.getMessage());
            throw new CustomException("451", "Something went wrong");
        }


    }

    public static <T> T toObject(String json, Class<T> type) {
        try {
            return objectMapper.readValue(json, type);
        } catch (Exception ex) {
            log.info("Error in JsonUtil class in method toObject: {}", ex.getMessage());
            throw new CustomException("451", "Something went wrong");
        }


    }

}
