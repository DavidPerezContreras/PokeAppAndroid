package perez.david.pokeappandroid.presentation.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import perez.david.pokeappandroid.domain.model.Pokemon

@Composable
fun Greeting(pokemon: Pokemon) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = "Name: ${pokemon.name}",
                modifier = Modifier.padding(8.dp)
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
        Greeting(Pokemon("David", url =""))

}