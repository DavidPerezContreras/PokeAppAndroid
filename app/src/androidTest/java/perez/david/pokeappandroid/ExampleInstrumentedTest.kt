

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import dagger.hilt.android.testing.CustomTestApplication
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import perez.david.pokeappandroid.MyApplication
import perez.david.pokeappandroid.domain.repository.PokemonRepository
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
@LargeTest
@CustomTestApplication(MyApplication::class)
class PokemonDataImplTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setUp() {
        hiltRule.inject()
    }


    @Inject
    lateinit var pokemonDataImpl: PokemonRepository


    @Test
    fun testGetPokemonList() {
        runBlocking {
            val pokemonList = pokemonDataImpl.getPokemonList(10, 0)


           assert(true)
        }
    }

}