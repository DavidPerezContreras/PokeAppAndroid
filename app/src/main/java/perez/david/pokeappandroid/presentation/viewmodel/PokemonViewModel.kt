    package perez.david.pokeappandroid.presentation.viewmodel


    /*
    @HiltViewModel
    class PokemonViewModel @Inject constructor (
        private val pokemonRepository: PokemonDataImpl
    ) : ViewModel() {
        private val _pokemonListState: MutableStateFlow<ResourceState<List<Pokemon>>> = MutableStateFlow(
            ResourceState.Loading())
        val pokemonListState: StateFlow<ResourceState<List<Pokemon>>> = _pokemonListState

        init {
            fetchPokemonList(20,0)
        }

        fun fetchPokemonList(limit:Int, offset:Int):Unit {
            viewModelScope.launch {
                try {
                    _pokemonListState.value = ResourceState.Loading()
                    val pokemonList = pokemonRepository.getPokemonList(limit,offset)
                    _pokemonListState.value = ResourceState.Success(pokemonList)
                } catch (e: Exception) {
                    _pokemonListState.value = ResourceState.Error(e.message ?: "An error occurred")
                }
            }
        }
    }
*/