package perez.david.pokeappandroid.presentation.composable

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import perez.david.pokeappandroid.model.Pokemon

@Composable
fun PokemonCard(pokemon: Pokemon) {
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { isExpanded = !isExpanded }
    ) {
        Row(
            Modifier.fillMaxWidth(),
        ) {
            AsyncImage(
                model = "https://oyster.ignimgs.com/mediawiki/apis.ign.com/pokemon-blue-version/8/89/Pikachu.jpg",
                contentDescription = pokemon.name + " Image",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(120.dp)
                    .padding(8.dp)
                    .clip(shape = RoundedCornerShape(4.dp)),
            )
            Text(
                text = "${pokemon.name}",
                modifier = Modifier.align(Alignment.CenterVertically),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

        }




        AnimatedVisibility(
            visible = isExpanded,
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut()
        ) {
            Text("This is the expandable content")
        }


    }
}


@Composable
fun CustomPokemonCard(pokemon: Pokemon) {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AsyncImage(
            model = "https://oyster.ignimgs.com/mediawiki/apis.ign.com/pokemon-blue-version/8/89/Pikachu.jpg",
            contentDescription = pokemon.name + " Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(120.dp)
                .padding(8.dp)
                .clip(shape = RoundedCornerShape(4.dp)),
        )
        Text(
            text = "This is a long text that may overflowwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww",
            modifier = Modifier.align(Alignment.CenterVertically),
            maxLines = 2,
            overflow = TextOverflow.Visible
        )

    }
}



@Preview(showBackground = true)
@Composable
fun PokemonCardPreview() {
        PokemonCard(Pokemon("David 11111111111111111111111111111", "url", listOf()))

}