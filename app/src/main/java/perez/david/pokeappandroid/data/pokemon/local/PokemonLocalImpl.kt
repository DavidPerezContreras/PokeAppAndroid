package perez.david.pokeappandroid.data.pokemon.local

import perez.david.pokeappandroid.model.Pokemon
import javax.inject.Inject


class PokemonLocalImpl @Inject constructor(

) {
    suspend fun getPokemonList(): List<Pokemon> {
        return listOf()
    }
}

