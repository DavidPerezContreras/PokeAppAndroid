package perez.david.pokeappandroid.data.api

import perez.david.pokeappandroid.domain.common.response.PokemonListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApiService {
    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit:Int, @Query("offset") offset:Int): PokemonListResponse
}