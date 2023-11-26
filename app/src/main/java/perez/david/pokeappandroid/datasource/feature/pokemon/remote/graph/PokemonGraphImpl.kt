package perez.david.pokeappandroid.datasource.feature.pokemon.remote.graph

import perez.david.pokeappandroid.datasource.feature.pokemon.remote.RemoteImpl
import perez.david.pokeappandroid.model.Pokemon
import javax.inject.Inject


class PokemonGraphImpl @Inject constructor(

) :RemoteImpl{
    override suspend fun getPokemonList(limit: Int, offset: Int): List<Pokemon> {
        return listOf()
    }
}

