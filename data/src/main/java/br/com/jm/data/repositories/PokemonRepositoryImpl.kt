package br.com.jm.data.repositories

import br.com.jm.domain.common.Result
import br.com.jm.domain.entities.Pokemon
import br.com.jm.domain.repositories.PokemonRepository
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton

class PokemonRepositoryImpl @Inject constructor(
    private val remoteDataSource: PokemonRemoteDataSource
): PokemonRepository {
    override suspend fun getPokemon(name: String): Result<Pokemon> {
        return remoteDataSource.getPokemon(name)
    }
}