package perez.david.pokeappandroid.datasource.feature.pokemon.remote.service

import perez.david.pokeappandroid.datasource.feature.pokemon.remote.model.RemotePokemonList
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApiService {
    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit:Int, @Query("offset") offset:Int): RemotePokemonList
}