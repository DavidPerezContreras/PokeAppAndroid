package perez.david.pokeappandroid.domain.repository

import perez.david.pokeappandroid.model.Pokemon


interface PokemonRepository {

    suspend fun getPokemonList(limit:Int, offset:Int): List<Pokemon>
}
