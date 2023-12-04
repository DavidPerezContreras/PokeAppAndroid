package perez.david.pokeappandroid.data.feature.pokemon


import perez.david.pokeappandroid.datasource.feature.pokemon.cache.PokemonCache
import perez.david.pokeappandroid.datasource.feature.pokemon.remote.RemoteImpl
import perez.david.pokeappandroid.domain.repository.PokemonRepository
import perez.david.pokeappandroid.model.Pokemon


class PokemonDataImpl(
    private val pokemonRemoteImpl: RemoteImpl,
    private val pokemonCache: PokemonCache //Singleton
) : PokemonRepository {


    override suspend fun getPokemonList(limit: Int, offset: Int): List<Pokemon> {
        //return pokemonRemoteImpl.getPokemonList(limit, offset)

        var vuelta: List<Pokemon> = listOf<Pokemon>()
        var cache = listOf<Pokemon>()

        cache = pokemonCache.getPokemonList(limit, offset)
        vuelta = if (pokemonCache.getCacheSize() > offset + limit + 2) {//2 era por que mejor que sobre...
            cache
        } else {
            val remotePokemonsChunk = pokemonRemoteImpl.getPokemonList(limit, offset)

            pokemonCache.addAllPokemon(remotePokemonsChunk)
            remotePokemonsChunk
        }


        return vuelta

    }
}
