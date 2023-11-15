package perez.david.pokeappandroid.domain.usecase

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import perez.david.pokeappandroid.model.Pokemon
import javax.inject.Inject

open class AllPokemonUseCase @Inject constructor(
    private val pager:Pager<Int, Pokemon>
) {
    @OptIn(ExperimentalPagingApi::class)
    operator fun invoke(limit: Int) = pager.flow
}