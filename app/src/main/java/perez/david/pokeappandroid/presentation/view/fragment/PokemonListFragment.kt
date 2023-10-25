package perez.david.pokeappandroid.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import perez.david.pokeappandroid.presentation.composable.PokemonList
import perez.david.pokeappandroid.presentation.theme.PokeAppAndroidTheme
import perez.david.pokeappandroid.presentation.viewmodel.PokemonListViewModel


// A simple ViewModel to handle the state of the input field


class PokemonListFragment : Fragment() {


    // Create a ViewModel instance for the InputFieldViewModel
    private val pokemonViewModel: PokemonListViewModel by activityViewModels<PokemonListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return ComposeView(requireContext()).apply {
            setContent {
                PokeAppAndroidTheme {

                    PokemonList(pokemonViewModel)

                }

            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Perform any other operations you need when the Fragment is created.
    }
}

