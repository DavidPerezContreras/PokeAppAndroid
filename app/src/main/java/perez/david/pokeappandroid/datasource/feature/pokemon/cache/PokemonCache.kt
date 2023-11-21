package perez.david.pokeappandroid.datasource.feature.pokemon.cache

import androidx.lifecycle.MutableLiveData
import perez.david.pokeappandroid.model.Pokemon
import javax.inject.Inject

class PokemonCache  {

    private val pokemonList: MutableList<Pokemon> = mutableListOf()
    fun getCacheSize():Int = pokemonList.size
    fun getPokemonList(limit: Int, offset: Int): List<Pokemon> {

        //TODO
        //return if (pokemonList.size !=0) {
            val subList:MutableList<Pokemon> = mutableListOf()
            for (i in offset until limit + offset) {

                if(pokemonList.toList().getOrNull(i)!=null){
                    subList[i]=(Pokemon((i+1).toString(),i+1))
                }
            }

            return subList
        //} else {
           // emptyList()
        //}
    }


    fun addAllPokemon(pokemons: List<Pokemon>) {
            pokemonList.addAll(pokemons)
    }
}