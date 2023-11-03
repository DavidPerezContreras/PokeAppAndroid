package perez.david.pokeappandroid.datasource.feature.pokemon.cache

import perez.david.pokeappandroid.model.Pokemon
import javax.inject.Inject

class PokemonCache @Inject constructor() {

    var pokemonList :MutableList<Pokemon> = mutableListOf<Pokemon>()


    suspend fun getPokemonList(limit:Int, offset:Int): List<Pokemon> {
        var vuelta= listOf<Pokemon>();


        var subList = pokemonList.subList(fromIndex = offset, toIndex = offset+limit)
        vuelta=subList;



        if(subList.size!=limit){
            vuelta= listOf<Pokemon>()
        }
        return vuelta
    }

}