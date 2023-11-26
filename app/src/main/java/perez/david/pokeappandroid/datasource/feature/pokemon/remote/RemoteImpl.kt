package perez.david.pokeappandroid.datasource.feature.pokemon.remote

import perez.david.pokeappandroid.model.Pokemon

interface RemoteImpl {
    suspend fun getPokemonList(limit: Int, offset: Int): List<Pokemon>
}