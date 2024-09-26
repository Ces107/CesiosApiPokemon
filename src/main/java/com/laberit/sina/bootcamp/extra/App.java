package com.laberit.sina.bootcamp.extra;


import com.laberit.sina.bootcamp.extra.api.PokemonGetter;
import com.laberit.sina.bootcamp.extra.models.Pokemon;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class App{
    public static void main(String[] args) throws Exception {
        Pokemon pokemonId1 = PokemonGetter.getById(1);
        System.out.println(pokemonId1.toString());

        Pokemon pikachu = PokemonGetter.getByName("pikachu");
        System.out.println(pikachu.toString());

        List<Pokemon> listOfPoke = PokemonGetter.getAllFilteredByName("ter");
        System.out.println(listOfPoke);


    }




}