package perez.david.pokeappandroid.presentation.composable


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import coil.compose.AsyncImage
import com.google.android.material.progressindicator.CircularProgressIndicator
import perez.david.pokeappandroid.domain.common.ResourceState
import perez.david.pokeappandroid.domain.model.Pokemon
import perez.david.pokeappandroid.presentation.theme.PokeAppAndroidTheme
import perez.david.pokeappandroid.presentation.view.Greeting



@Composable
fun PokemonList(pokemonListResourceState: ResourceState<List<Pokemon>>){
    when (val resourceState = pokemonListResourceState) {
        is ResourceState.Loading -> {
            // Handle loading state
            CircularProgressIndicator()
        }
        is ResourceState.Success -> {
            val data = resourceState.result as List<Pokemon>
            if (data.isNotEmpty()) {



                // Handle success with data
                return PokeAppAndroidTheme {

                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        // Use the data here
                        Column {
                            data.forEach { pokemon ->


                                Card(modifier = Modifier
                                    .fillMaxWidth()

                                    .padding(Dp(10f), Dp(10f), Dp(10f), Dp(10f))){
                                    Row(){
                                        Greeting(pokemon.name)
                                        AsyncImage(
                                            model = "https://i.ebayimg.com/images/g/V9wAAOSw~e5ZU~Ls/s-l1200.webp",
                                            contentDescription = "Translated description of what the image contains", modifier = Modifier.fillMaxSize()

                                        )
                                    }
                                }

                            }
                        }
                    }
                }
            } else {
                // Handle success with an empty list
                PokeAppAndroidTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Text("No Pokemon found.")
                    }
                }
            }
        }
        is ResourceState.Error -> {
            // Handle error state
            PokeAppAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Text("Error: ${resourceState.error}")
                }
            }
        }

        else -> {}
    }


}
