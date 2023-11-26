package perez.david.pokeappandroid.datasource.feature.pokemon.remote.api

import perez.david.pokeappandroid.datasource.feature.pokemon.remote.RemoteImpl
import perez.david.pokeappandroid.datasource.feature.pokemon.remote.api.service.PokemonApiService
import perez.david.pokeappandroid.model.Pokemon
import retrofit2.Retrofit
import javax.inject.Inject

class PokemonApiRemoteImpl @Inject constructor(retrofit: Retrofit) :RemoteImpl{

    private val pokemonService = retrofit.create(PokemonApiService::class.java)


    fun extractId(url: String): Int {
        var vuelta = url.dropLast(1) // Drops last slash
        var lastIndexOfSlash = vuelta.lastIndexOf("/")
        vuelta = vuelta.substring(lastIndexOfSlash + 1, vuelta.length)
        print("pokemon id: $vuelta")
        return vuelta.toInt()
    }


    override suspend fun getPokemonList(limit: Int, offset: Int): List<Pokemon> {
        val pokemons = mutableListOf<Pokemon>()

        val remotePokemonList = pokemonService.getPokemonList(limit, offset).results
        remotePokemonList.forEach{
            pokemons.add(Pokemon(it.name, url = it.url, listOf()))
        }

        return pokemons.toList()
    }

}


/*

    suspend fun getPokemonList(limit: Int, offset: Int): List<Pokemon> {
        try {
            val pokemons = mutableListOf<Pokemon>()
            val remotePokemonList = pokemonService.getPokemonList(limit, offset).results

            coroutineScope {
                val pokemonDetailsDeferred = remotePokemonList.map { remotePokemon ->
                    val id = extractId(remotePokemon.url)
                    val id2=id+1
                    async { getPokemonById(id) }
                }

                pokemonDetailsDeferred.awaitAll().forEachIndexed { index, remotePokemonDetails ->

                    //Fetch
                    var abilities:List<Ability> = getAbilityList(remotePokemonDetails.abilities.map { it ->RemoteAbility(name=it.remoteAbility.name, url = it.remoteAbility.url)})


                    val pokemon = Pokemon(
                        name = remotePokemonDetails.name,
                        id = extractId(remotePokemonList[index].url),
                        abilities = abilities
                    )

                    print(abilities.toString())

                    pokemons.add(pokemon)
                }
            }

            return pokemons
        } catch (e: Exception) {
            throw e
        }
    }


}

*/



