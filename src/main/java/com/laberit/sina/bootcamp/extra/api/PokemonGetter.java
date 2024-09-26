package com.laberit.sina.bootcamp.extra.api;

import com.laberit.sina.bootcamp.extra.models.Pokemon;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.laberit.sina.bootcamp.extra.services.PokemonService.url2List;
import static com.laberit.sina.bootcamp.extra.services.PokemonService.url2PokemonConverter;


public class PokemonGetter {

    private static final String BASE_URL = "https://pokeapi.co/api/v2/pokemon/";



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
                    try {
                        return url2PokemonConverter(BASE_URL + n2);
                    } catch (Exception e) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return listaPokemon;
    }
}
