package perez.david.pokeappandroid.data.feature.pokemon

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import perez.david.pokeappandroid.datasource.feature.pokemon.cache.PokemonCache
import perez.david.pokeappandroid.datasource.feature.pokemon.remote.PokemonRemoteImpl
import perez.david.pokeappandroid.domain.repository.PokemonRepository
import perez.david.pokeappandroid.model.Pokemon
import javax.inject.Inject



class PokemonDataImpl @Inject constructor(
    private val pokemonRemoteImpl: PokemonRemoteImpl,
    private val pokemonCache: PokemonCache //Singleton
    ) : PokemonRepository {


    override suspend fun getPokemonList(limit:Int, offset:Int): List<Pokemon> = withContext(Dispatchers.IO) {
        val remotePokemonsChunk = pokemonRemoteImpl.getPokemonList(limit, offset)

        pokemonCache.pokemonList.addAll(remotePokemonsChunk);


        remotePokemonsChunk
    }
}