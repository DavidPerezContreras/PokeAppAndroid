package perez.david.pokeappandroid.datasource.feature.pokemon.cache

import perez.david.pokeappandroid.model.Pokemon
import javax.inject.Inject

class PokemonCache  {

    private val pokemonList: MutableList<Pokemon> = mutableListOf()

    // Synchronize access to pokemonList
    fun getPokemonList(limit: Int, offset: Int): List<Pokemon> {
        synchronized(this) {
            val subList = pokemonList.subList(fromIndex = offset, toIndex = offset + limit)
            return if (subList.size == limit) {
                subList.toList()
            } else {
                emptyList()
            }
        }
    }

    // Add a method to update pokemonList (if needed)
    fun addAllPokemon(pokemons: List<Pokemon>) {
        synchronized(this) {
            pokemonList.addAll(pokemons)
        }
    }
}