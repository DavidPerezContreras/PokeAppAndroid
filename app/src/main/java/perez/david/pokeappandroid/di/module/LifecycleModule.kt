package perez.david.pokeappandroid.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import perez.david.pokeappandroid.data.PokemonDataImpl
import perez.david.pokeappandroid.data.pokemon.local.PokemonLocalImpl
import perez.david.pokeappandroid.data.pokemon.paging.PokemonPagingSource
import perez.david.pokeappandroid.data.pokemon.remote.PokemonRemoteImpl
import perez.david.pokeappandroid.domain.repository.PokemonRepository
import perez.david.pokeappandroid.domain.usecase.AllPokemonUseCase
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun providePokemonRepository(
        pokemonLocalImpl: PokemonLocalImpl, pokemonRemoteImpl: PokemonRemoteImpl
    ): PokemonRepository {
        return PokemonDataImpl(
            pokemonRemoteImpl,
            pokemonLocalImpl
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
