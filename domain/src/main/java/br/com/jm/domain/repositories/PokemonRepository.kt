package br.com.jm.domain.repositories

import br.com.jm.domain.common.Result
import br.com.jm.domain.entities.Pokemon

interface PokemonRepository {
    suspend fun getPokemon(name: String): Result<Pokemon>
}