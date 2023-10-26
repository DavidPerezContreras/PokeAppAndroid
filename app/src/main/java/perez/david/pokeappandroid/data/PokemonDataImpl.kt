package perez.david.pokeappandroid.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import perez.david.pokeappandroid.data.pokemon.local.PokemonLocalImpl
import perez.david.pokeappandroid.data.pokemon.remote.PokemonRemoteImpl
import perez.david.pokeappandroid.domain.repository.PokemonRepository
import perez.david.pokeappandroid.model.Pokemon
import javax.inject.Inject



class PokemonDataImpl @Inject constructor(
    private val pokemonRemoteImpl: PokemonRemoteImpl,
    private val pokemonLocalImpl: PokemonLocalImpl
    ) : PokemonRepository {


    override suspend fun getPokemonList(limit:Int, offset:Int): List<Pokemon> {
        withContext(Dispatchers.IO) {
            Thread.sleep(2000)
        }
        return pokemonRemoteImpl.getPokemonList(limit, offset)
    }

}