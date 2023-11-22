package perez.david.pokeappandroid.datasource.feature.pokemon.cache

import androidx.lifecycle.MutableLiveData
import perez.david.pokeappandroid.model.Pokemon
import javax.inject.Inject

class PokemonCache  {

    private val pokemonList: MutableList<Pokemon> = mutableListOf()
    fun getCacheSize():Int = pokemonList.size
    fun getPokemonList(limit: Int, offset: Int): List<Pokemon> {

            val subList:MutableList<Pokemon> = mutableListOf()
            for (i in offset until limit + offset) {
                val pok: Pokemon? =pokemonList.getOrNull(i)
                if (pok != null) {
                    subList.add(Pokemon(pok.name,i+1))
                }
            }

            return subList
    }


    fun addAllPokemon(pokemons: List<Pokemon>) {
            pokemonList.addAll(pokemons)
    }
}