package perez.david.pokeappandroid.domain.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import perez.david.pokeappandroid.datasource.feature.pokemon.paging.PokemonPagingSource
import javax.inject.Inject

open class AllPokemonUseCase @Inject constructor(
    private val pagingSource: PokemonPagingSource
) {
    operator fun invoke(limit: Int) = Pager(
        // aquí el tamaño de página se comporta de forma curiosa,
        // la primera petición (es así) multiplica el pagesize * 3
        config = PagingConfig(
            pageSize = limit,
            enablePlaceholders = false,
            maxSize = 30,
            prefetchDistance = 3,
            initialLoadSize = limit
        ),
        pagingSourceFactory = {
            pagingSource
        }
    ).flow // Si nos fijamos creamos un flow directamente desde el caso de uso.
}