package perez.david.pokeappandroid.presentation.view.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import perez.david.pokeappandroid.R
import perez.david.pokeappandroid.presentation.composable.AboutPage
import perez.david.pokeappandroid.presentation.composable.HomePage
import perez.david.pokeappandroid.presentation.theme.PokeAppAndroidTheme
import perez.david.pokeappandroid.presentation.viewmodel.PokemonListViewModel

// A simple ViewModel to handle the state of the input field


class MainFragment : Fragment() {


    // Create a ViewModel instance for the InputFieldViewModel
    private val pokemonViewModel: PokemonListViewModel by activityViewModels<PokemonListViewModel>()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        return ComposeView(requireContext()).apply {


            setContent {


                PokeAppAndroidTheme {
                    val navController = rememberNavController()
                    val items = listOf(context.getString(R.string.home), context.getString(R.string.about))

                    Scaffold(bottomBar = {
                        NavigationBar {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentRoute = navBackStackEntry?.arguments?.getString("route")

                            var screenIndex:Int=1;
                            items.forEach { screen ->
                                val icon = if(screenIndex==1){
                                    Icons.Filled.Home
                                } else {
                                    Icons.Filled.AccountBox
                                }
                                NavigationBarItem(icon = {
                                    Icon(
                                        icon,
                                        contentDescription = null
                                    )
                                }, // Change icon as per your requirement
                                    label = { Text(screen) },
                                    selected = currentRoute == screen,
                                    onClick = {
                                        navController.navigate(screen) {
                                            popUpTo(0)
                                            launchSingleTop = true
                                        }
                                    }
                                )
                                screenIndex++

                            }
                        }
                    }) {paddingValues ->
                        NavHost(
                            navController,
                            startDestination = "home",
                        ) {
                            composable("home") {
                                HomePage(pokemonViewModel,paddingValues)
                            }
                            composable("about") {
                                AboutPage()
                            }
                        }
                    }
                }

            }


        }
    }

}

