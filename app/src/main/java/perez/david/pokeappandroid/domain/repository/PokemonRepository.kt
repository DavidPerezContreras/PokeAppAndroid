package perez.david.pokeappandroid.domain.repository

import perez.david.pokeappandroid.domain.model.Pokemon


interface PokemonRepository {

    suspend fun getPokemonList(limit:Int, offset:Int): List<Pokemon>
}
