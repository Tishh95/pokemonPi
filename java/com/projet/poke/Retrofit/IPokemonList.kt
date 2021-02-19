package com.projet.poke.Retrofit

import com.projet.poke.Model.Pokedex
import io.reactivex.Observable
import java.util.*
import retrofit2.http.GET

interface IPokemonList {
    @get:GET("pokedex.json")
    val listPokemon:Observable<Pokedex>


}