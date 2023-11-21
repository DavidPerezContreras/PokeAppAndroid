package perez.david.pokeappandroid.datasource.feature.pokemon.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import perez.david.pokeappandroid.domain.repository.PokemonRepository
import perez.david.pokeappandroid.model.Pokemon
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class PokemonPagingSource
@Inject constructor(
    private val pokemonRepository: PokemonRepository
) : PagingSource<Int, Pokemon>() {
    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return ( (state.anchorPosition ?: 0) - state.config.initialLoadSize / 2).coerceAtLeast(0)
    }
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        try {
            val page = params.key ?: 0
            val limit = params.loadSize
            var offset=page*limit
            var response: List<Pokemon> = listOf()


               response = pokemonRepository.getPokemonList(
                   limit,offset
               )




            return LoadResult.Page(
                data = response,
                prevKey = if (page == 0) null else page.minus(1),
                nextKey = if (response.isEmpty()) null else page.plus(1),
            )


        } catch (e: Exception) {
            return LoadResult.Error(e)
        }

    }

    /*override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return null
    }*/
}