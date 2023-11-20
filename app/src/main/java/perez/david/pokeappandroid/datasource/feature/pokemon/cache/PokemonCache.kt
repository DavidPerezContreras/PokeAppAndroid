package perez.david.pokeappandroid.datasource.feature.pokemon.cache

import androidx.lifecycle.MutableLiveData
import perez.david.pokeappandroid.model.Pokemon
import javax.inject.Inject

class PokemonCache  {

    private val pokemonList: MutableList<Pokemon> = mutableListOf()

    fun getPokemonList(limit: Int, offset: Int): List<Pokemon> {

            val subList = pokemonList.subList(fromIndex = offset, toIndex = offset + limit)
            return if (subList.size == limit) {
                subList
            } else {
                emptyList()
            }

    }


    fun addAllPokemon(pokemons: List<Pokemon>) {
            pokemonList.addAll(pokemons)
    }
}