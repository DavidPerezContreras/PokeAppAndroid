package perez.david.pokeappandroid.datasource.feature.pokemon.remote.model


// /pokemon limit,offset
data class RemotePokemonList(
    val count: Int,
    val results: List<RemotePokemon>
)

data class RemotePokemon(
    val name: String,
    val url: String
)

data class RemotePokemonDetails(
    val name:String,
    val id:String,
    val abilities:List<RemoteAbilityWrapper>
)
