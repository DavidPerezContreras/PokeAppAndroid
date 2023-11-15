package perez.david.pokeappandroid.di.module

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import perez.david.pokeappandroid.data.feature.pokemon.PokemonDataImpl
import perez.david.pokeappandroid.datasource.feature.pokemon.cache.PokemonCache
import perez.david.pokeappandroid.datasource.feature.pokemon.local.PokemonLocalImpl
import perez.david.pokeappandroid.datasource.feature.pokemon.paging.PokemonPagingSource
import perez.david.pokeappandroid.datasource.feature.pokemon.paging.PokemonRemoteMediator
import perez.david.pokeappandroid.datasource.feature.pokemon.remote.PokemonRemoteImpl
import perez.david.pokeappandroid.domain.repository.PokemonRepository
import perez.david.pokeappandroid.domain.usecase.AllPokemonUseCase
import perez.david.pokeappandroid.model.Pokemon
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    fun providePokemonRepository(
        pokemonCache: PokemonCache, pokemonRemoteImpl: PokemonRemoteImpl
    ): PokemonRepository {
        return PokemonDataImpl(
            pokemonRemoteImpl,
            pokemonCache
        ) 
    }

    @Provides
    fun providePokemonLocalImpl(
    ): PokemonLocalImpl {
        return PokemonLocalImpl()
    }

    @Provides
    fun providePokemonRemoteImpl(
        retrofit: Retrofit
    ): PokemonRemoteImpl {
        return PokemonRemoteImpl(retrofit)
    }


    @Provides
    fun provideAllPokemonUseCase(
        pager:Pager<Int,Pokemon>
    ): AllPokemonUseCase {
        return AllPokemonUseCase(pager)
    }

    @Provides
    @Singleton
    fun providePokemonPagingMediator(
        pokemonRepository: PokemonRepository
    ): PokemonRemoteMediator {
        return PokemonRemoteMediator(pokemonRepository)
    }


    @Provides
    @Singleton
    fun providePokemonPagingSource(
        pokemonRepository: PokemonRepository
    ): PokemonPagingSource {
        return PokemonPagingSource(pokemonRepository)
    }


    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun providePager(
        pokemonRemoteMediator: PokemonRemoteMediator,
        pokemonPagingSource: PokemonPagingSource
    ): Pager<Int,Pokemon> {
        return Pager<Int,Pokemon>(
                remoteMediator =pokemonRemoteMediator,
                config = PagingConfig(
                    pageSize = 10,
                    prefetchDistance = 10 -1
                ),
                pagingSourceFactory = {
                    pokemonPagingSource
                }
            )
    }




}
