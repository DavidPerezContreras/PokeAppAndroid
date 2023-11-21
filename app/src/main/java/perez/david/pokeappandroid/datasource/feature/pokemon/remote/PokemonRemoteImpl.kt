package perez.david.pokeappandroid.datasource.feature.pokemon.remote

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import perez.david.pokeappandroid.datasource.feature.pokemon.remote.model.RemoteAbility
import perez.david.pokeappandroid.datasource.feature.pokemon.remote.model.RemoteAbilityDetails
import perez.david.pokeappandroid.datasource.feature.pokemon.remote.model.RemotePokemonDetails
import perez.david.pokeappandroid.datasource.feature.pokemon.remote.service.PokemonApiService
import perez.david.pokeappandroid.model.Ability
import perez.david.pokeappandroid.model.Pokemon
import retrofit2.Retrofit
import javax.inject.Inject

class PokemonRemoteImpl @Inject constructor(retrofit: Retrofit){

    private val pokemonService = retrofit.create(PokemonApiService::class.java)


    fun extractId(url: String): Int {
        var vuelta = url.dropLast(1) // Drops last slash
        var lastIndexOfSlash = vuelta.lastIndexOf("/")
        vuelta = vuelta.substring(lastIndexOfSlash + 1, vuelta.length)
        print("pokemon id: $vuelta")
        return vuelta.toInt()
    }


    suspend fun getPokemonById(id:Int): RemotePokemonDetails {
        return pokemonService.getPokemonDetails(id)
    }

    suspend fun getAbilityById(id:Int): RemoteAbilityDetails {
        return pokemonService.getAbilityDetails(id)
    }





    suspend fun getAbilityList(remoteAbilityList: List<RemoteAbility>): List<Ability> {
        val abilities = mutableListOf<Ability>()
        for (remoteAbility in remoteAbilityList) {
            val id:Int=extractId(remoteAbility.url)
            val abilityDetails = getAbilityById(1)
            abilities.add(Ability(name=abilityDetails.name, id=abilityDetails.id, flavorTextEntries = abilityDetails.flavorTextEntries))
        }
        return abilities
    }


    suspend fun getPokemonList(limit: Int, offset: Int): List<Pokemon> {
        val pokemons = mutableListOf<Pokemon>()

        val remotePokemonList = pokemonService.getPokemonList(limit, offset).results
        remotePokemonList.forEach{
            pokemons.add(Pokemon(it.name,extractId(it.url)))
        }

        return pokemons.toList()
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
                    var abilities:List<Ability> = getAbilityList(remotePokemonDetails.abilities.map { it ->RemoteAbility(name=it.ability.name, url = it.ability.url)})


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

*/
}


