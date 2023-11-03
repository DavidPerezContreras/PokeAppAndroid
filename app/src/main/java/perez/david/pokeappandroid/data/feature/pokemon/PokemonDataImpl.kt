package perez.david.pokeappandroid.data.feature.pokemon

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import perez.david.pokeappandroid.datasource.feature.pokemon.PokemonRemoteImpl
import perez.david.pokeappandroid.datasource.feature.pokemon.cache.PokemonCache
import perez.david.pokeappandroid.domain.repository.PokemonRepository
import perez.david.pokeappandroid.model.Pokemon
import javax.inject.Inject



class PokemonDataImpl @Inject constructor(
    private val pokemonRemoteImpl: PokemonRemoteImpl,
    private val pokemonCache: PokemonCache //Singleton
    ) : PokemonRepository {


    override suspend fun getPokemonList(limit:Int, offset:Int): List<Pokemon> {
        withContext(Dispatchers.IO) {
            Thread.sleep(1000)
        }




        val remotePokemonsChunk=pokemonRemoteImpl.getPokemonList(limit, offset)
        //once we have the remote pokemon we store it in cache.
        // pokemonCache is a singleton for pokemon Feature
        pokemonCache.pokemonList.addAll(remotePokemonsChunk);


        //We return an INMUTABLE list.
        // We always read from the cache,
        //Paging ensures us to keep it up to date.
        // we just must see if that chunk is stored already. and take it from there.
        //Thats how it should work

        return pokemonCache.pokemonList
    }

}