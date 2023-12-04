package perez.david.pokeappandroid.datasource.feature.pokemon.remote.api.model

import com.google.gson.annotations.SerializedName

data class RemoteAbility(val name:String, val url:String)

data class RemoteAbilityDetails(
    val id :Int,
    val name:String,
    @SerializedName("flavor_text_entries") val flavorTextEntries:List<FlavorText>
)



data class RemoteAbilityWrapper(
    @SerializedName("ability")val remoteAbility: RemoteAbility)
