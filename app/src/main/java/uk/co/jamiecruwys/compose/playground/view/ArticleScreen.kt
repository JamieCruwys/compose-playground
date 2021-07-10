package uk.co.jamiecruwys.compose.playground.view

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import uk.co.jamiecruwys.compose.playground.Article

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun ArticleScreen(
    originalArticles: List<Article>?,
) {
    val articles = originalArticles?.toMutableList() ?: mutableListOf()

    val chosenAction = remember { mutableStateOf(MenuActionType.NONE) }

    val actions = listOf(
        MenuAction.GroupByYear {
            chosenAction.value = MenuActionType.GROUP_BY_YEAR
        },
        MenuAction.Filter {
            chosenAction.value = MenuActionType.FILTER
        },
        MenuAction.Empty {
            chosenAction.value = MenuActionType.EMPTY
        }
    )

    MaterialTheme {
        Column {
            TopAppBar(
                title = {
                    Text("Items example", color = Color.White)
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

            val shouldGroupByYear = chosenAction.value == MenuActionType.GROUP_BY_YEAR

            when (chosenAction.value) {
                MenuActionType.NONE -> {
                    articles.clear()
                    articles.addAll(originalArticles ?: listOf())
                }
                MenuActionType.EMPTY -> {
                    articles.clear()
                }
                MenuActionType.GROUP_BY_YEAR -> {
                    articles.clear()
                    articles.addAll(originalArticles ?: listOf())
                }
                MenuActionType.FILTER -> {
                    articles.clear()
                    articles.addAll(originalArticles ?: listOf())
                }
            }

            if (articles.isNotEmpty()) {
                ArticleFeed(articles, shouldGroupByYear)
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