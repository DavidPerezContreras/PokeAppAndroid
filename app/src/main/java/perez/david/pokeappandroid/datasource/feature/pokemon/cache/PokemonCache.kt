package perez.david.pokeappandroid.datasource.feature.pokemon.cache

import perez.david.pokeappandroid.model.Pokemon
class PokemonCache  {

    private val pokemonList: MutableList<Pokemon> = mutableListOf()

    suspend fun getPokemonList(limit: Int, offset: Int): List<Pokemon> {

            var size=pokemonList.size


            val subList = mutableListOf<Pokemon>()

            for(i in offset until limit+offset){
                subList.add(i+1, Pokemon(i.toString(),i, listOf()))
            }

            var vuelta=subList.toList()

        return vuelta

    }


    suspend fun addAllPokemon(pokemons: List<Pokemon>) {
            pokemonList.addAll(pokemons)
    }
}