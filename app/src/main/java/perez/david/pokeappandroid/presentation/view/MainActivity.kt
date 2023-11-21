package perez.david.pokeappandroid.presentation.view


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import dagger.hilt.android.AndroidEntryPoint
import perez.david.pokeappandroid.R
import perez.david.pokeappandroid.presentation.composable.PokemonList
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