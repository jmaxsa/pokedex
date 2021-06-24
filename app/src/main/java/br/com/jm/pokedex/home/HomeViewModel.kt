package br.com.jm.pokedex.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.jm.domain.common.Result
import br.com.jm.domain.entities.Pokemon
import br.com.jm.domain.usecase.GetPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPokemonUseCase: GetPokemonUseCase
): ViewModel() {
    fun getPokemon(pokemonName: String) {
        viewModelScope.launch {
            when(val pokemon = getPokemonUseCase.invoke(pokemonName)) {
                is Result.Success<Pokemon> -> { Log.i("Pokemon Name: ", pokemon.data.name) }
                else -> {}
            }
        }
    }
}