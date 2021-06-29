package uk.co.jamiecruwys.compose.playground.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import uk.co.jamiecruwys.compose.playground.Article

@Preview
@Composable
fun DefaultPreview() {
    ArticleFeed(
        listOf(
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
        )
    )
}
