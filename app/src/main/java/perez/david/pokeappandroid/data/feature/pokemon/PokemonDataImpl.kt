package perez.david.pokeappandroid.data.feature.pokemon


import perez.david.pokeappandroid.datasource.feature.pokemon.cache.PokemonCache
import perez.david.pokeappandroid.datasource.feature.pokemon.remote.PokemonRemoteImpl
import perez.david.pokeappandroid.domain.repository.PokemonRepository
import perez.david.pokeappandroid.model.Pokemon


class PokemonDataImpl (
    private val pokemonRemoteImpl: PokemonRemoteImpl,
    private val pokemonCache: PokemonCache //Singleton
    ) : PokemonRepository {


    override suspend fun getPokemonList(limit: Int, offset: Int): List<Pokemon> {
        //return pokemonRemoteImpl.getPokemonList(limit, offset)

        val cache=pokemonCache.getPokemonList(offset,offset+limit)
        val vuelta:List<Pokemon> = if(cache.size==limit){
            cache
        }else{
            val remotePokemonsChunk = pokemonRemoteImpl.getPokemonList(limit, offset)

            pokemonCache.addAllPokemon(remotePokemonsChunk)
            remotePokemonsChunk
        }


        return vuelta

    }
}
/*
override suspend fun getPokemonList(limit:Int, offset:Int): List<Pokemon> {

    val cache=pokemonCache.pokemonList.subList(offset,offset+limit)
    val vuelta:List<Pokemon> = if(cache.size==limit){
        cache
    }else{
        val remotePokemonsChunk = pokemonRemoteImpl.getPokemonList(limit, offset)

        pokemonCache.pokemonList.addAll(remotePokemonsChunk);
        remotePokemonsChunk
    }


    return vuelta
}
}
*/

