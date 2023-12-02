package perez.david.pokeappandroid.presentation.composable

import android.widget.GridView
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import perez.david.pokeappandroid.model.Pokemon
import java.util.Locale

@Composable
fun PokemonCard(pokemon: Pokemon) {
    var isExpanded by remember { mutableStateOf(false) }

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp).clip(RoundedCornerShape(8.dp))
        .clickable { isExpanded = !isExpanded }
    )
    {
        Row(
            Modifier.fillMaxWidth(),
        ) {
            LoadImageWithCoilAndProgress(data = pokemon.officialArtwork, pokemon.name)
            Text(
                text = pokemon.url.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(Color.Gray)
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
                    .clip(RoundedCornerShape(8.dp))
                    ,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(
                    fontWeight = FontWeight.Bold, fontSize = 17.sp, color = Color.White
                )
            )

        }




        AnimatedVisibility(
            visible = isExpanded,
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut()
        ) {


            Box(
                modifier = Modifier.height(160.dp)
            ) {
                Column {

                    Box(Modifier.padding(horizontal=50.dp)){
                        Text(
                            "Abilities",
                            style = TextStyle(fontSize = 21.sp),
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = Color.LightGray)

                        )
                    }


                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        contentPadding = PaddingValues(16.dp),
                    ) {
                        items(pokemon.abilities.size) { index ->

                                Text(
                                    pokemon.abilities[index].name.replaceFirstChar {
                                        if (it.isLowerCase()) it.titlecase(
                                            Locale.getDefault()
                                        ) else it.toString()
                                    },
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(8.dp).fillMaxWidth().background(
                                        Color(255,100,100,100)
                                    ),
                                    style = TextStyle(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 20.sp,

                                    ), fontStyle = FontStyle(1)
                                )
                            }



                    }
                }


            }


        }


    }
}

@Composable
fun LoadImageWithCoilAndProgress(data: String, contentDescription: String) {
    val imagePainter = rememberAsyncImagePainter(model = data)

    Box(
        contentAlignment = Alignment.Center, modifier = Modifier.size(120.dp)
    ) {
        Image(
            painter = imagePainter,
            contentDescription = "$contentDescription Image",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(120.dp)
                .padding(8.dp)
                .clip(shape = RoundedCornerShape(4.dp)),
        )

        if (imagePainter.state is AsyncImagePainter.State.Loading) {
            CircularProgressIndicator()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PokemonCardPreview() {
    PokemonCard(
        Pokemon(
            "David 11111111111111111111111111111",
            "url",
            listOf(),
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png"
        )
    )

}