package perez.david.pokeappandroid.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import perez.david.pokeappandroid.data.feature.pokemon.PokemonDataImpl
import perez.david.pokeappandroid.datasource.feature.pokemon.PokemonRemoteImpl
import perez.david.pokeappandroid.datasource.feature.pokemon.cache.PokemonCache
import perez.david.pokeappandroid.datasource.feature.pokemon.local.PokemonLocalImpl
import perez.david.pokeappandroid.datasource.feature.pokemon.paging.PokemonPagingSource
import perez.david.pokeappandroid.domain.repository.PokemonRepository
import perez.david.pokeappandroid.domain.usecase.AllPokemonUseCase
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun providePokemonRepository(
        pokemonCache: PokemonCache, pokemonRemoteImpl: PokemonRemoteImpl
    ): PokemonRepository {
        return PokemonDataImpl(
            pokemonRemoteImpl,
            pokemonCache

        ) // or however your repository is created
    }

    @Provides
    fun providePokemonLocalImpl(
    ): PokemonLocalImpl {
        return PokemonLocalImpl() // or however your repository is created
    }

    @Provides
    fun providePokemonRemoteImpl(
        retrofit: Retrofit
    ): PokemonRemoteImpl {
        return PokemonRemoteImpl(retrofit) // or however your repository is created
    }


    @Provides
    fun provideAllPokemonUseCase(
        pokemonRepository: PokemonRepository
    ): AllPokemonUseCase {
        return AllPokemonUseCase(PokemonPagingSource(pokemonRepository)) // or however your repository is created
    }


}
