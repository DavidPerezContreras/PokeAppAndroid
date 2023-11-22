package perez.david.pokeappandroid.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import perez.david.pokeappandroid.data.feature.pokemon.PokemonDataImpl
import perez.david.pokeappandroid.datasource.feature.pokemon.cache.PokemonCache
import perez.david.pokeappandroid.datasource.feature.pokemon.local.PokemonLocalImpl
import perez.david.pokeappandroid.datasource.feature.pokemon.paging.PokemonPagingSource
import perez.david.pokeappandroid.datasource.feature.pokemon.remote.PokemonRemoteImpl
import perez.david.pokeappandroid.domain.repository.PokemonRepository
import perez.david.pokeappandroid.domain.usecase.AllPokemonUseCase
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePokemonCache():PokemonCache{
        return PokemonCache()
    }

    @Provides
    fun providePokemonRepository(
        pokemonCache: PokemonCache, pokemonRemoteImpl: PokemonRemoteImpl
    ): PokemonRepository {
        return PokemonDataImpl(
            pokemonRemoteImpl,
            pokemonCache
        )
    }

}
