package uk.co.jamiecruwys.compose.playground.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uk.co.jamiecruwys.compose.playground.Article

@Composable
fun ArticleFeed(articles: List<Article>) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        articles.forEach { article ->
            ArticleItem(article)
        }
    }
}

@Preview
@Composable
fun ArticleFeedPreview() {
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