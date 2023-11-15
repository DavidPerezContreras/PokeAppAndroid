package perez.david.pokeappandroid.datasource.feature.pokemon.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
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
            val page = params.key?:1
            val limit=params.loadSize


            val response = pokemonRepository.getPokemonList(
                limit =limit,
                offset = page*limit
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
}



@OptIn(ExperimentalPagingApi::class)
class PokemonRemoteMediator @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : RemoteMediator<Int, Pokemon>() {

    override suspend fun load(loadType: LoadType, state: PagingState<Int, Pokemon>): MediatorResult {
        try {
            val page = when (loadType) {
                LoadType.REFRESH -> 1
                LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                        ?: return MediatorResult.Success(endOfPaginationReached = true)
                    (lastItem.id / state.config.pageSize) + 1
                }
            }

            val limit = state.config.pageSize

            val response = pokemonRepository.getPokemonList(
                limit = limit,
                offset = (page - 1) * limit
            )

            //pokemonRepository.insertPokemonList(response)

            return MediatorResult.Success(endOfPaginationReached = response.isEmpty())
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }
}
