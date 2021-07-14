package uk.co.jamiecruwys.compose.playground.view

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import uk.co.jamiecruwys.compose.playground.Article
import uk.co.jamiecruwys.compose.playground.repository.ArticleRepository
import uk.co.jamiecruwys.compose.playground.R

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun ArticleScreen(
    viewModel: ArticleScreenViewModel = viewModel(),
) {
    val articles = viewModel.articles.observeAsState()

    val actions = listOf(
        MenuAction.GroupByYear {
            viewModel.groupByYear()
        },
        MenuAction.Filter {
            viewModel.load()
        },
        MenuAction.Empty {
            viewModel.showEmpty()
        }
    )

    MaterialTheme {
        Column {
            TopAppBar(
                title = {
                    Text(
                        "Items example",
                        color = colorResource(R.color.appbar_text_color)
                    )
                },
                actions = {
                    actions.forEach { action ->
                        IconButton(action.action) {
                            Icon(
                                painter = painterResource(id = action.icon),
                                contentDescription = stringResource(id = action.label)
                            )
                        }
                    }
                }
            )

            articles.value.apply {
                if (isNullOrEmpty()) {
                    ArticleEmptyState()
                } else {
                    ArticleFeed(this)
                }
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
        ArticleScreen(
            ArticleScreenViewModel(object: ArticleRepository() {
                override fun getArticles(): List<Article> = listOf()
            })
        )
    }
}

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Preview
@Composable
fun ArticleScreenItemsPreview() {
    Column {
        ArticleScreen(
            ArticleScreenViewModel(object: ArticleRepository() {
                override fun getArticles(): List<Article> = listOf(
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
            })
        )
    }
}
