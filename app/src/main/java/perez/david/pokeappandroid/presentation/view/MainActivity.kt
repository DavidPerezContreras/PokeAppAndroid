package perez.david.pokeappandroid.presentation.view


import android.os.Bundle
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import dagger.hilt.android.AndroidEntryPoint
import perez.david.pokeappandroid.R
import perez.david.pokeappandroid.model.Pokemon
import perez.david.pokeappandroid.model.ResourceState
import perez.david.pokeappandroid.presentation.theme.PokeAppAndroidTheme
import perez.david.pokeappandroid.presentation.view.fragment.PokemonListFragment
import java.util.Locale

@AndroidEntryPoint
class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Use your XML layout for the activity
        setContentView(R.layout.fragment_pokemon)

        // Create and commit the fragment to the container
        if (savedInstanceState == null) {
            val fragment = PokemonListFragment() // Create an instance of your fragment
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
        }

    }
}

@Composable
fun PokemonListWidget(pokemonListResourceState: ResourceState<List<Pokemon>>) {
    when (pokemonListResourceState) {
        is ResourceState.Loading<List<Pokemon>> -> {
            // Handle loading state
            CircularProgressIndicator()
        }

        is ResourceState.Success -> {
            val data = pokemonListResourceState.result as List<Pokemon>
            if (data.isNotEmpty()) {
                // Handle success with data
                PokeAppAndroidTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        // Use the data here
                        Column {
                            data.forEach { pokemon ->
                                Card() {

                                    Greeting(pokemon.name)
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
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Text("Error: ${pokemonListResourceState.error}")
                }
            }
        }


        else -> {}
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }, modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokeAppAndroidTheme {
        Greeting("nombre 1")
    }
}