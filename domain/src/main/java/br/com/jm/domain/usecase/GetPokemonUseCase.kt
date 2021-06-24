package br.com.jm.domain.usecase

import br.com.jm.domain.repositories.PokemonRepository
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(private val repository: PokemonRepository) {
    suspend operator fun invoke(name: String) = repository.getPokemon(name)
}