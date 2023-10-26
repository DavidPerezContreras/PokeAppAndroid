package perez.david.pokeappandroid.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import perez.david.pokeappandroid.model.Pokemon

@Composable
fun PokemonCard(pokemon: Pokemon) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = "Name: ${pokemon.name}",
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)
                )
                // You can add more information here if needed
            }
            AsyncImage(
                model = "https://oyster.ignimgs.com/mediawiki/apis.ign.com/pokemon-blue-version/8/89/Pikachu.jpg",
                contentDescription = pokemon.name + " Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .padding(8.dp)
                    .clip(shape = RoundedCornerShape(4.dp))
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PokemonCardPreview() {
        PokemonCard(Pokemon("David", url =""))

}