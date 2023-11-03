package perez.david.pokeappandroid.datasource.feature.pokemon.remote.model

data class RemotePokemonList(
    val count: Int,
    val results: List<RemotePokemon>
)

data class RemotePokemon(
    val name: String,
    val url: String
)
