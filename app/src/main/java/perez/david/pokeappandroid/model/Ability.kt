package perez.david.pokeappandroid.model

import perez.david.pokeappandroid.datasource.feature.pokemon.remote.api.model.FlavorText

data class Ability(
    val id :Int,
    val name:String,
    val flavorTextEntries:List<FlavorText>
)
