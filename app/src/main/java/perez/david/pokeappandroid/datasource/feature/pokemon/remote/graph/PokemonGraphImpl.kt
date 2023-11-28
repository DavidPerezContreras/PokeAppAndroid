package perez.david.pokeappandroid.datasource.feature.pokemon.remote.graph

import com.apollographql.apollo.api.create
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.cache.normalized.RecordFieldJsonAdapter.Companion.create
import perez.david.pokeappandroid.datasource.feature.pokemon.remote.RemoteImpl
import perez.david.pokeappandroid.model.Pokemon
import javax.inject.Inject


class PokemonGraphImpl @Inject constructor(

) :RemoteImpl{

    val apolloClient = ApolloClient.builder()
        .serverUrl("https://graphql-pokemon2.vercel.app/")
        .build()





    override suspend fun getPokemonList(limit: Int, offset: Int): List<Pokemon> {
        return listOf()
    }
}

