package perez.david.pokeappandroid.data

import perez.david.pokeappandroid.data.pokemon.local.PokemonLocalImpl
import perez.david.pokeappandroid.data.pokemon.remote.PokemonRemoteImpl
import perez.david.pokeappandroid.domain.model.Pokemon
import perez.david.pokeappandroid.domain.repository.PokemonRepository
import javax.inject.Inject



class PokemonDataImpl @Inject constructor(
    private val pokemonRemoteImpl: PokemonRemoteImpl,
    private val pokemonLocalImpl: PokemonLocalImpl
    ) : PokemonRepository {


    override suspend fun getPokemonList(limit:Int, offset:Int): List<Pokemon> {
        return pokemonRemoteImpl.getPokemonList(limit, offset)
    }

}