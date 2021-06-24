package br.com.jm.data.repositories

import br.com.jm.data.api.PokemonApi
import br.com.jm.domain.common.Result
import br.com.jm.domain.entities.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

class PokemonRemoteDataSourceImpl @Inject constructor(
    private val service: PokemonApi
) : PokemonRemoteDataSource {
    override suspend fun getPokemon(pokemon: String): Result<Pokemon> =
        withContext(Dispatchers.IO) {
            try {
                val response = service.getPokemon(pokemon)

                if (response.isSuccessful) {
                    return@withContext Result.Success(response.body()!!)
                } else {
                    return@withContext Result.Error(Exception(response.message()))
                }
            } catch (e: Exception) {
                return@withContext Result.Error(e)
            }
        }
}