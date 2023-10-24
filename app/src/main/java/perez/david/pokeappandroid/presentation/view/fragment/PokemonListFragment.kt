package perez.david.pokeappandroid.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import perez.david.pokeappandroid.domain.common.ResourceState
import perez.david.pokeappandroid.domain.model.Pokemon
import perez.david.pokeappandroid.presentation.composable.PokemonList
import perez.david.pokeappandroid.presentation.viewmodel.PokemonViewModel


// A simple ViewModel to handle the state of the input field


class PokemonListFragment : Fragment() {
    // Create a ViewModel instance for the InputFieldViewModel
    private val pokemonViewModel: PokemonViewModel by activityViewModels<PokemonViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //pokemonViewModel.fetchPokemonList(20,0)

        return ComposeView(requireContext()).apply {
            setContent {
                val pokemonListResourceState: ResourceState<List<Pokemon>> =pokemonViewModel.pokemonListState.collectAsState().value
                PokemonList(pokemonListResourceState = pokemonListResourceState)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Perform any other operations you need when the Fragment is created.
    }
}

