package perez.david.pokeappandroid.presentation.view


import android.os.Bundle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import dagger.hilt.android.AndroidEntryPoint
import perez.david.pokeappandroid.R
import perez.david.pokeappandroid.presentation.theme.PokeAppAndroidTheme
import perez.david.pokeappandroid.presentation.view.fragment.MainFragment

@AndroidEntryPoint
class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Use your XML layout for the activity
        setContentView(R.layout.fragment_main)

        // Create and commit the fragment to the container
        if (savedInstanceState == null) {
            val fragment = MainFragment() // Create an instance of your fragment
            supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokeAppAndroidTheme {
        Text("nombre 1")
    }
}