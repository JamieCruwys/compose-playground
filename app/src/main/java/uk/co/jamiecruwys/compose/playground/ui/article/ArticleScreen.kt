package uk.co.jamiecruwys.compose.playground.ui.article

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.rememberNavController
import uk.co.jamiecruwys.compose.playground.R
import uk.co.jamiecruwys.compose.playground.domain.ArticleFilter
import uk.co.jamiecruwys.compose.playground.domain.Resource
import uk.co.jamiecruwys.compose.playground.ui.article.list.ArticleFeed
import uk.co.jamiecruwys.compose.playground.ui.bottomnav.BottomNavigationScreens
import uk.co.jamiecruwys.compose.playground.viewmodel.ArticleScreenViewModel

@Suppress("LongMethod")
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun ArticleScreen(
    viewModel: ArticleScreenViewModel = hiltViewModel(),
    navController: NavHostController,
) {
    val state = viewModel.state.observeAsState()

    val actions = listOf(
        ArticleScreenMenuAction.GroupByYear {
            viewModel.load(filter = ArticleFilter.YEAR)
        },
        ArticleScreenMenuAction.Filter {
            viewModel.load(filter = ArticleFilter.NONE)
        },
        ArticleScreenMenuAction.Empty {
            viewModel.load(filter = ArticleFilter.EMPTY)
        }
    )

    Column {
        TopAppBar(
            title = {
                Text(stringResource(R.string.article_app_bar_title))
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
                            ArticleFeed(
                                data = this,
                                onFavourite = { id ->
                                    viewModel.favouriteArticle(id)
                                },
                                onUnfavourite = { id ->
                                    viewModel.unFavouriteArticle(id)
                                },
                                onItemTap = {
                                    navController.navigate(
                                        BottomNavigationScreens.ArticleDetail.route,
                                        navOptions = NavOptions.Builder()
                                            .setPopUpTo(
                                                route = BottomNavigationScreens.Feed.route,
                                                inclusive = false
                                            )
                                            .build()
                                    )
                                }
                            )
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

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Preview
@Composable
fun ArticleScreenEmptyPreview() {
    // ArticleScreen()
}
