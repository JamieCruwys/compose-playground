package uk.co.jamiecruwys.compose.playground.view

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import uk.co.jamiecruwys.compose.playground.Article
import uk.co.jamiecruwys.compose.playground.repository.ArticleRepository

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun ArticleScreen(
    modifier: Modifier = Modifier,
    viewModel: ArticleScreenViewModel = viewModel(),
) {
    val articles = viewModel.articles.observeAsState()
    Box(modifier) {
        articles.value?.let { items ->
            if (items.isEmpty()) {
                ArticleEmptyState()
            } else {
                ArticleFeed(items)
            }
        } ?: ArticleEmptyState()
    }
}

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Preview
@Composable
fun ArticleScreenPreview() {
    val previews = remember {
        listOf(
            ArticleScreenViewModel(
                object: ArticleRepository() {
                    override fun getArticles(): List<Article>? = null
                }
            ),
            ArticleScreenViewModel(
                object: ArticleRepository() {
                    override fun getArticles(): List<Article>? = listOf(
                        Article(
                            "Title",
                            "Subtitle",
                            "Date",
                            2020,
                            null
                        )
                    )
                }
            ),
        )
    }

    Column {
        for (preview in previews) {
            ArticleScreen()
        }
    }
}