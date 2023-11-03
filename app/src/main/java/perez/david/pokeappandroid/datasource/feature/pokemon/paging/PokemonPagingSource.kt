package perez.david.pokeappandroid.datasource.feature.pokemon.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import perez.david.pokeappandroid.domain.repository.PokemonRepository
import perez.david.pokeappandroid.model.Pokemon
import javax.inject.Inject

class PokemonPagingSource
@Inject constructor(
    private val pokemonRepository: PokemonRepository
) : PagingSource<Int, Pokemon>() {
    override fun getRefreshKey(state: PagingState<Int, Pokemon>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        try {
            val page = params.key ?: 0
            val limit = params.loadSize
            //Timber.tag("Paging").i("Page: $page")
            // Puede ser un flow, o una suspend que se traiga cosas de cualquier sitio,
            // es un repositorio, por tanto...
            val response = pokemonRepository.getPokemonList(
                limit,page*limit
            )

            //TODO(/*GET THEIR DETAILS*/)





            return LoadResult.Page(
                data = response,
                prevKey = if (page == 0) null else page.minus(1),
                nextKey = if (response.isEmpty()) null else page.plus(1),
            )


        } catch (e: Exception) {
            return LoadResult.Error(e)
        }

    }
}