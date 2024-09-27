package com.laberit.sina.bootcamp.extra;

import com.laberit.sina.bootcamp.extra.models.Pokemon;

import java.util.List;

import static com.laberit.sina.bootcamp.extra.api.PokemonGetter.*;

public class Main {


    public static void main(String[] args) throws Exception {
        Pokemon pokemonId1 = getById(1);
        System.out.println(pokemonId1.toString());

        Pokemon pikachu = getByName("pikachu");
        System.out.println(pikachu.toString());

        List<Pokemon> listOfPoke = getAllFilteredByName("ter");
        System.out.println(listOfPoke);

    }
}
