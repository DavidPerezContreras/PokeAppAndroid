package perez.david.pokeappandroid.datasource.feature.pokemon.remote.api.model

import com.google.gson.annotations.SerializedName


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
    val abilities:List<RemoteAbilityWrapper>,
    @SerializedName("sprites")val sprite:RemoteSprite
)
