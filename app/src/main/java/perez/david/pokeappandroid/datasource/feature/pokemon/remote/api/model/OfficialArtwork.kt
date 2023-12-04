package perez.david.pokeappandroid.datasource.feature.pokemon.remote.api.model

import com.google.gson.annotations.SerializedName

class RemoteSprite (
    @SerializedName("other")val remoteOther:RemoteOther
)   {

fun getFrontDefault():String{
    return remoteOther.remoteOfficialArtwork.frontDefault
}

}

data class RemoteOther(
    @SerializedName("official-artwork") val remoteOfficialArtwork: RemoteOfficialArtwork
)


data class RemoteOfficialArtwork(
    @SerializedName("front_default")val frontDefault:String
)