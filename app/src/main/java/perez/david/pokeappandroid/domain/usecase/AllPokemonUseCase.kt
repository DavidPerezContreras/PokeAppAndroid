package perez.david.pokeappandroid.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingConfig.Companion.MAX_SIZE_UNBOUNDED
import perez.david.pokeappandroid.datasource.feature.pokemon.paging.PokemonPagingSource
import javax.inject.Inject

open class AllPokemonUseCase @Inject constructor(
    private val pagingSource: PokemonPagingSource
) {
    operator fun invoke(limit: Int) = Pager(
        config = PagingConfig(
            pageSize = limit,
            enablePlaceholders = false,
            maxSize = 60,
            //maxSize= MAX_SIZE_UNBOUNDED, //disables lazy loading, cachedIn(viewmodelScope) not working
            prefetchDistance = 20,
            initialLoadSize = limit,
        ),
        pagingSourceFactory = {
            pagingSource
        }
    ).flow
}