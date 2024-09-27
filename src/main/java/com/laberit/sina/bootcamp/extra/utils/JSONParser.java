package com.laberit.sina.bootcamp.extra.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONParser {
    private static final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static List<String> toStringList(HttpEntity entity) throws IOException, ParseException {
        List<String> listOfPokemon = new ArrayList<>();

        String jsonResponse = EntityUtils.toString(entity);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonResponse);

        JsonNode resultsNode = rootNode.path("results");

        for (int i = 0; i < resultsNode.size(); i++) {
            JsonNode node = resultsNode.get(i);
            String name = node.path("name").asText();
            listOfPokemon.add(name);
        }

        return listOfPokemon;


    }

    public static <T> T toObject(HttpEntity httpEntity, Class<T> clazz) {
        try {
            String bodyResponseAsJson = EntityUtils.toString(httpEntity);
            return objectMapper.readValue(bodyResponseAsJson, clazz);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
