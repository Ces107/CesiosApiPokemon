package com.laberit.sina.bootcamp.extra.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;

public class JSONParser {
    private static final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static <T> T toObject(HttpEntity httpEntity, Class<T> clazz) {
        try {
            String bodyResponseAsJson = EntityUtils.toString(httpEntity);
            return objectMapper.readValue(bodyResponseAsJson, clazz);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
