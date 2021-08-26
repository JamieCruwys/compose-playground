package uk.co.jamiecruwys.navigation

import app.cash.turbine.test
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import kotlin.time.ExperimentalTime

@ExperimentalTime
@ExperimentalCoroutinesApi
class NavigationTest {
    private lateinit var manager: NavigationManager

    @BeforeEach
    fun setup() {
        manager = NavigationManager()
    }

    @Test
    fun `when navigation manager is created, then emit the default value`() = runBlockingTest {
        manager.commands.test {
            expectThat(expectItem()).isEqualTo(BottomNavigationDirections.default)
            expectComplete()
        }
    }

    @Test
    fun `when navigation event is sent, then emit the value`() = runBlockingTest {
        val event = BottomNavigationDirections.favourites

        manager.navigate(event)

        manager.commands.test {
            expectThat(expectItem()).isEqualTo(event)
            expectComplete()
        }
    }

    @Test
    fun testf() {
        assert(true)
    }
}
