
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import perez.david.pokeappandroid.datasource.feature.pokemon.cache.PokemonCache
import perez.david.pokeappandroid.datasource.feature.pokemon.remote.PokemonRemoteImpl
import perez.david.pokeappandroid.domain.repository.PokemonRepository
import javax.inject.Inject

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@LargeTest
@HiltAndroidTest
class PokemonDataImplTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var pokemonRepository: PokemonRepository

    @Inject
    lateinit var pokemonRemoteImpl: PokemonRemoteImpl

    @Inject
    lateinit var pokemonCache: PokemonCache

    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        hiltRule.inject()
    }

    @Test
    fun testGetPokemonList() = testDispatcher.runBlockingTest {
        val testLimit = 10
        val testOffset = 0

        val result = pokemonRepository.getPokemonList(testLimit, testOffset)

        assertEquals(10, result.size)
    }
}
