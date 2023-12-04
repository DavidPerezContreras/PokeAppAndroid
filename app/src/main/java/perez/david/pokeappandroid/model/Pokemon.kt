package perez.david.pokeappandroid.model

import perez.david.pokeappandroid.datasource.feature.pokemon.remote.api.model.RemoteOfficialArtwork

data class Pokemon(
    val name:String,
    val url: String,
    val abilities: List<Ability>,
    val officialArtwork:String
)
