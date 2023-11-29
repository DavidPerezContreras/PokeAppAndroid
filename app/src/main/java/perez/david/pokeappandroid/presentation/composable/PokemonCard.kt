    package perez.david.pokeappandroid.presentation.composable

    import android.widget.GridView
    import androidx.compose.animation.AnimatedVisibility
    import androidx.compose.animation.expandVertically
    import androidx.compose.animation.fadeIn
    import androidx.compose.animation.fadeOut
    import androidx.compose.animation.shrinkVertically
    import androidx.compose.foundation.background
    import androidx.compose.foundation.clickable
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.PaddingValues
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.size
    import androidx.compose.foundation.lazy.grid.GridCells
    import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.layout.ContentScale
    import androidx.compose.ui.text.TextStyle
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.text.style.TextAlign
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
                    model = pokemon.officialArtwork,
                    contentDescription = pokemon.name + " Image",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(120.dp)
                        .padding(8.dp)
                        .clip(shape = RoundedCornerShape(4.dp)),
                )
                Text(
                    text = pokemon.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(Color.Gray, shape = RoundedCornerShape(8.dp))
                        .padding(16.dp)
                        .align(Alignment.CenterVertically),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.White
                    )
                )

            }




            AnimatedVisibility(
                visible = isExpanded,
                enter = expandVertically() + fadeIn(),
                exit = shrinkVertically() + fadeOut()
            ) {


            Box(
                modifier = Modifier.height(200.dp)){
                Column{


                    Text("Abilities",
                        style=TextStyle(fontSize = 24.sp),
                        textAlign = TextAlign.Center,
                        modifier=Modifier
                            .fillMaxWidth()
                            .background(color = Color.DarkGray)
                    )

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        contentPadding = PaddingValues(16.dp),
                    ) {
                        items(pokemon.abilities.size) { index ->
                            Card(
                                modifier = Modifier
                                    .background(color = Color.Gray, shape = RoundedCornerShape(8.dp))
                                    .padding(8.dp)
                            ) {
                                Text(
                                    pokemon.abilities[index].name,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp)
                                        .background(color = Color.Transparent) // Optional: Set a transparent background for the text
                                        .padding(8.dp),
                                    style = TextStyle(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 14.sp,
                                        color = Color.White
                                    )
                                )
                            }
                        }
                    }

                }
            }

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
            PokemonCard(Pokemon("David 11111111111111111111111111111", "url", listOf(),"https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png"))

    }