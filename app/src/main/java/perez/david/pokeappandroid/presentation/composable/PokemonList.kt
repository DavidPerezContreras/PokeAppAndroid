
package perez.david.pokeappandroid.presentation.composable


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import perez.david.pokeappandroid.presentation.viewmodel.PokemonListViewModel
import java.util.UUID

@Composable
fun PokemonList(viewModel: PokemonListViewModel) {
    val pokemons = viewModel.allPokemonFlow.collectAsLazyPagingItems()

    val isRefreshing = pokemons.loadState.refresh is LoadState.Loading
    val isAppending = pokemons.loadState.append is LoadState.Loading

    Scaffold { paddingValues ->
            if(pokemons.itemCount<=0){
                Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.BottomCenter) {
                    LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
                }
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                items(
                    count = pokemons.itemCount,
                    key = pokemons.itemKey { _ -> UUID.randomUUID().toString() }
                ) { characterIndex ->
                    pokemons[characterIndex]?.let { item ->
                        PokemonCard(pokemon = item)
                    }

                    // Check if we're at the last item in the list
                    if (characterIndex == pokemons.itemCount - 1) {
                        // Show the LinearProgressIndicator at the bottom


                        if (isRefreshing || isAppending) {
                            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
                        }
                    }
                }
            }

    }
}