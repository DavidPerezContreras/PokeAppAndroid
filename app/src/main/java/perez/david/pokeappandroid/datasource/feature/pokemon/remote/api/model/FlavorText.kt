package perez.david.pokeappandroid.datasource.feature.pokemon.remote.api.model

import com.google.gson.annotations.SerializedName

data class FlavorText(
    @SerializedName("flavor_text") val flavorText: String,
    @SerializedName("language") val language: FlavorTextLanguage,
)


data class FlavorTextLanguage(
    @SerializedName("name") val name:String,
)