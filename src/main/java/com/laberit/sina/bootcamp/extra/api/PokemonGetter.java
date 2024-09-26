package com.laberit.sina.bootcamp.extra.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.laberit.sina.bootcamp.extra.models.Pokemon;
import com.laberit.sina.bootcamp.extra.utils.JSONParser;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class PokemonGetter {

    private static final String BASE_URL = "https://pokeapi.co/api/v2/pokemon/";

    private static HttpEntity makeRequest(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(request);
        return response.getEntity();
    }

    private static Pokemon url2PokemonConverter(String url) throws Exception {
        HttpEntity entity = makeRequest(url);
        return JSONParser.toObject(entity, Pokemon.class);
    }


    private static List<String> url2List(String url) throws Exception {
        HttpEntity entity = makeRequest(url);

        List<String> listOfPokemon = new ArrayList<>();
        if (entity != null) {

            String jsonResponse = EntityUtils.toString(entity);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonResponse);

            JsonNode resultsNode = rootNode.path("results");

            for (JsonNode node : resultsNode) {
                String name = node.path("name").asText();
                listOfPokemon.add(name);
            }
        }

        return listOfPokemon;

    }





    public static Pokemon getById(int id) throws Exception {
        String url = BASE_URL + id;
        return url2PokemonConverter(url);
    }

    public static Pokemon getByName(String name) throws Exception {
        String url = BASE_URL + name;
        return url2PokemonConverter(url);

    }

    public static List<Pokemon> getAllFilteredByName(String name) throws Exception {
        String url = BASE_URL + "?limit=250";
        List<String> listStrings = url2List(url);

        List<Pokemon> listaPokemon = listStrings.stream()
                .filter(n -> n.toLowerCase().contains(name.toLowerCase()))
                .map(n2 -> {
                    try { return url2PokemonConverter(BASE_URL + n2); } catch (Exception e) {return null;}
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return listaPokemon;
    }
}
