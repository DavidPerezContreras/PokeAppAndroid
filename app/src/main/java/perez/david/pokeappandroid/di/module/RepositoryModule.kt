package perez.david.pokeappandroid.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import perez.david.pokeappandroid.data.feature.pokemon.PokemonDataImpl
import perez.david.pokeappandroid.datasource.feature.pokemon.cache.PokemonCache
import perez.david.pokeappandroid.datasource.feature.pokemon.remote.api.PokemonApiRemoteImpl
import perez.david.pokeappandroid.domain.repository.PokemonRepository
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
        pokemonCache: PokemonCache, pokemonRemoteImpl: PokemonApiRemoteImpl //Cuando la api de GrapQL esté implementada sólo hay que cambiar una clase por otra.
    ): PokemonRepository {
        return PokemonDataImpl(
            pokemonRemoteImpl,
            pokemonCache
        )
    }

}
