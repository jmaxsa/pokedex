package br.com.jm.data.api

import br.com.jm.domain.entities.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET("pokemon/{name}")
    suspend fun getPokemon(@Path("name") name: String): Response<Pokemon>
}