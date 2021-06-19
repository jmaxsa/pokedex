package br.com.jm.data.api

import br.com.jm.data.entities.Pokemon
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApi {
    @GET
    suspend fun getPokemon(): Response<Pokemon>
}