    package perez.david.pokeappandroid.presentation.viewmodel

    import androidx.lifecycle.ViewModel
    import androidx.lifecycle.viewModelScope
    import androidx.paging.Pager
    import androidx.paging.PagingConfig
    import androidx.paging.PagingData
    import androidx.paging.cachedIn
    import dagger.hilt.android.lifecycle.HiltViewModel
    import kotlinx.coroutines.flow.Flow
    import kotlinx.coroutines.flow.MutableStateFlow
    import kotlinx.coroutines.flow.asStateFlow
    import kotlinx.coroutines.launch
    import perez.david.pokeappandroid.domain.usecase.AllPokemonUseCase
    import perez.david.pokeappandroid.model.Pokemon
    import javax.inject.Inject

    @HiltViewModel
    class PokemonListViewModel @Inject constructor(
        private val allPokemonUseCase: AllPokemonUseCase,
    ) : ViewModel() {

        private val _pokemonResponse: MutableStateFlow<PagingData<Pokemon>> =
            MutableStateFlow(PagingData.empty())
        var pokemonFlow = _pokemonResponse.asStateFlow()
            private set


        init {
            viewModelScope.launch {
                allPokemonUseCase.invoke(10).cachedIn(viewModelScope).collect {
                    _pokemonResponse.value = it
                }
            }
        }



    }
