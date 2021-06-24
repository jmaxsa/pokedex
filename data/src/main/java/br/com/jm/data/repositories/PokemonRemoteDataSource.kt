package br.com.jm.data.repositories

import br.com.jm.domain.common.Result
import br.com.jm.domain.entities.Pokemon

interface PokemonRemoteDataSource {
    suspend fun getPokemon(pokemon: String): Result<Pokemon>
}