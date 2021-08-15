package com.fortune.demo.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtil {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String toJson(Object value) throws JsonProcessingException {
        return mapper.writeValueAsString(value);
    }
}
