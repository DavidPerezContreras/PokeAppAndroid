package perez.david.pokeappandroid.datasource.feature.pokemon.cache

import androidx.lifecycle.MutableLiveData
import perez.david.pokeappandroid.model.Pokemon
import javax.inject.Inject

class PokemonCache  {

    private val pokemonList: MutableLiveData<List<Pokemon>> = MutableLiveData<List<Pokemon>>(listOf<Pokemon>())

    fun getPokemonList(limit: Int, offset: Int): List<Pokemon> {

            val subList = pokemonList.value!!.subList(fromIndex = offset, toIndex = offset + limit).toList()
            return if (subList.size == limit) {
                subList
            } else {
                emptyList()
            }

    }


    fun addAllPokemon(pokemons: List<Pokemon>) {
            pokemonList.value= pokemonList.value?.plus(pokemons)
    }
}