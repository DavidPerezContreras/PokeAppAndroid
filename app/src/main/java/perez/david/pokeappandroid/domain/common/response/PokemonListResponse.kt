package perez.david.pokeappandroid.domain.common.response

data class PokemonListResponse(
    val count: Int,
    val results: List<PokemonResult>
)

data class PokemonResult(
    val name: String,
    val url: String
)
