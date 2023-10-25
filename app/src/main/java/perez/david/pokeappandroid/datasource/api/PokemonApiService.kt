package perez.david.pokeappandroid.datasource.api

import perez.david.pokeappandroid.datasource.api.response.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApiService {
    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit:Int, @Query("offset") offset:Int): PokemonListResponse
}