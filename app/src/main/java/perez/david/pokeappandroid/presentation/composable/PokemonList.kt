package perez.david.pokeappandroid.presentation.composable


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import perez.david.pokeappandroid.presentation.viewmodel.PokemonListViewModel
import perez.david.pokeappandroid.presentation.viewmodel.PokemonViewModel
import java.util.UUID

@Composable
fun PokemonPagingList( pokemonViewModel: PokemonViewModel){
}

@Composable
fun PokemonList(viewModel: PokemonListViewModel){
    val pokemons = viewModel.allPokemonFlow.collectAsLazyPagingItems()
Scaffold(){paddingValues ->
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(paddingValues))

    {
        items(
            count = pokemons.itemCount,
            key = pokemons.itemKey { pokemon -> UUID.randomUUID().toString() } //Al haber nombres de pokemons y url repetidas al parecer en varios items, he generado un UUID.
        ){ characterIndex ->
            pokemons[characterIndex]?.let { item ->
                Text(item.name)
            }
        }
    }
}

}
