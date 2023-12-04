package perez.david.pokeappandroid.datasource.feature.pokemon.remote.api.service

import perez.david.pokeappandroid.datasource.feature.pokemon.remote.api.model.RemoteAbilityDetails
import perez.david.pokeappandroid.datasource.feature.pokemon.remote.api.model.RemotePokemonDetails
import perez.david.pokeappandroid.datasource.feature.pokemon.remote.api.model.RemotePokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService {
    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit:Int, @Query("offset") offset:Int): RemotePokemonList

    @GET("pokemon/{id}")
    suspend fun getPokemonDetails(@Path("id") id: Int): RemotePokemonDetails

    @GET("ability/{id}")
    suspend fun getAbilityDetails(@Path("id") id: Int): RemoteAbilityDetails

}