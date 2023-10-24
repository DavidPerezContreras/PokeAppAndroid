package perez.david.pokeappandroid.data.pokemon.remote

import perez.david.pokeappandroid.data.api.PokemonApiService
import perez.david.pokeappandroid.domain.model.Pokemon
import retrofit2.Retrofit
import javax.inject.Inject

class PokemonRemoteImpl @Inject constructor(retrofit: Retrofit){

    private val pokemonService = retrofit.create(PokemonApiService::class.java)

    suspend fun getPokemonList(limit:Int, offset:Int): List<Pokemon> {
        try {
            return pokemonService.getPokemonList(limit,offset).results.map { Pokemon(it.name,it.url) }
        } catch (e: Exception) {
            // Handle network or API errors here
            throw e
        }
    }

}