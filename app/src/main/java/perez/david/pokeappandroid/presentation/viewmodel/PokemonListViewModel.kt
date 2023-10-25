    package perez.david.pokeappandroid.presentation.viewmodel

    import androidx.lifecycle.ViewModel
    import androidx.paging.PagingData
    import dagger.hilt.android.lifecycle.HiltViewModel
    import kotlinx.coroutines.flow.Flow
    import perez.david.pokeappandroid.domain.usecase.AllPokemonUseCase
    import perez.david.pokeappandroid.model.Pokemon
    import javax.inject.Inject

    @HiltViewModel
    class PokemonListViewModel @Inject constructor(
        private val allPokemonUseCase: AllPokemonUseCase,
    ) : ViewModel() {

        val allPokemonFlow: Flow<PagingData<Pokemon>> = allPokemonUseCase(20)


    }
