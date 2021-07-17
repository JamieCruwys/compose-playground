package uk.co.jamiecruwys.compose.playground.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import uk.co.jamiecruwys.compose.playground.domain.Article
import uk.co.jamiecruwys.compose.playground.data.NetworkArticleRepository
import uk.co.jamiecruwys.compose.playground.domain.ArticleFilter
import uk.co.jamiecruwys.compose.playground.domain.Resource

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun ArticleScreen(
    viewModel: ArticleScreenViewModel = viewModel(),
) {
    val state = viewModel.state.observeAsState()

    val actions = listOf(
        MenuAction.GroupByYear {
            viewModel.load(filter = ArticleFilter.YEAR)
        },
        MenuAction.Filter {
            viewModel.load(filter = ArticleFilter.NONE)
        },
        MenuAction.Empty {
            viewModel.load(filter = ArticleFilter.EMPTY)
        }
    )

    MaterialTheme {
        Column {
            TopAppBar(
                title = {
                    Text("Items example")
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

            state.value.apply {
                when (this) {
                    is Resource.Loading -> {
                        ArticleLoadingState()
                    }
                    is Resource.Loaded -> {
                        data.apply {
                            if (isNullOrEmpty()) {
                                ArticleEmptyState()
                            } else {
                                ArticleFeed(data = this)
                            }
                        }
                    }
                    is Resource.Failed -> {
                        ArticleErrorState()
                    }
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
    ArticleScreen()
}
