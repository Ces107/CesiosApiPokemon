package com.laberit.sina.bootcamp.extra.services;

import com.laberit.sina.bootcamp.extra.api.HttpClientHelper;
import com.laberit.sina.bootcamp.extra.models.Pokemon;
import com.laberit.sina.bootcamp.extra.utils.JSONParser;
import org.apache.hc.core5.http.HttpEntity;

import java.util.List;

public class PokemonService {

    public static Pokemon url2PokemonConverter(String url) throws Exception {
        HttpEntity entity = HttpClientHelper.makeRequest(url);
        return JSONParser.toObject(entity, Pokemon.class);
    }

    public static List<String> url2List(String url) throws Exception {
        HttpEntity entity = HttpClientHelper.makeRequest(url);

        if (entity == null) {
            return null;
        } else {
            return JSONParser.toStringList(entity);
        }

    }
}
