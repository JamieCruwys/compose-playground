package uk.co.jamiecruwys.compose.playground

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import uk.co.jamiecruwys.compose.playground.view.ArticleFeed

class ComposeTest {
    @get:Rule
    val rule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setup() {
        rule.setContent {
            ArticleFeed(DUMMY_ARTICLES)
        }
    }

    @ExperimentalTestApi
    @Test
    fun test_articles_shown() {
        assertText("One title")
        assertText("One subtitle")
        assertText("December 2016")

        assertText("Two title")
        assertText("Two subtitle")
        assertText("December 2017")

        assertText("Three title")
        assertText("Three subtitle")
        assertText("December 2018")

        assertText("Four title")
        assertText("Four subtitle")
        assertText("December 2019")

        assertText("Five title")
        assertText("Five subtitle")
        assertText("December 2020")
    }

    private fun assertText(text: String) {
        rule.onNodeWithText(text).performScrollTo().assertExists()
    }

    companion object {
        private val DUMMY_ARTICLES = listOf(
            Article(
                title = "One title",
                subtitle = "One subtitle",
                date = "December 2016"
            ),
            Article(
                title = "Two title",
                subtitle = "Two subtitle",
                date = "December 2017"
            ),
            Article(
                title = "Three title",
                subtitle = "Three subtitle",
                date = "December 2018"
            ),
            Article(
                title = "Four title",
                subtitle = "Four subtitle",
                date = "December 2019"
            ),
            Article(
                title = "Five title",
                subtitle = "Five subtitle",
                date = "December 2020"
            ),
        )
    }
}