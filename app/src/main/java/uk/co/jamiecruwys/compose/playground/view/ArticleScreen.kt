package uk.co.jamiecruwys.compose.playground.view

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import uk.co.jamiecruwys.compose.playground.Article

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun ArticleScreen(
    articles: List<Article>?,
) {
    MaterialTheme {
        Column {
            TopAppBar(title = {
                Text("Items example")
            })

            if (articles?.isNotEmpty() == true) {
                ArticleFeed(articles)
            } else {
                ArticleEmptyState()
            }
        }
    }
}

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Preview
@Composable
fun ArticleScreenEmptyPreview() {
    Column {
        ArticleScreen(listOf())
    }
}

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Preview
@Composable
fun ArticleScreenItemsPreview() {
    Column {
        ArticleScreen(
            listOf(
                Article(
                    "Title 1",
                    "Subtitle 1",
                    "Date 1",
                    2020,
                    null
                ),
                Article(
                    "Title 2",
                    "Subtitle 2",
                    "Date 2",
                    2021,
                    null
                )
            )
        )
    }
}