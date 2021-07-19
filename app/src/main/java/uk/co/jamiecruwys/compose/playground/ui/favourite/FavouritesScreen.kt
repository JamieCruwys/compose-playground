package uk.co.jamiecruwys.compose.playground.ui.favourite

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import timber.log.Timber
import uk.co.jamiecruwys.compose.playground.R
import uk.co.jamiecruwys.compose.playground.domain.Resource
import uk.co.jamiecruwys.compose.playground.ui.article.list.ArticleFeed
import uk.co.jamiecruwys.compose.playground.viewmodel.FavouritesScreenViewModel

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun FavouritesScreen(
    viewModel: FavouritesScreenViewModel = viewModel(),
) {
    val state = viewModel.state.observeAsState()

    val actions = listOf(
        FavouritesScreenMenuAction.Refresh {
            viewModel.load()
        },
    )

    Column {
        TopAppBar(
            title = {
                Text(stringResource(R.string.favourites_app_bar_title))
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
                    FavouritesLoadingState()
                }
                is Resource.Loaded -> {
                    data.apply {
                        Timber.d("Favourites = $this")

                        if (isNullOrEmpty()) {
                            FavouritesEmptyState()
                        } else {
                            ArticleFeed(
                                data = this,
                                onFavourite = { id ->
                                    viewModel.favouriteArticle(id)
                                    viewModel.load()
                                },
                                onUnfavourite = { id ->
                                    viewModel.unFavouriteArticle(id)
                                    viewModel.load()
                                }
                            )
                        }
                    }
                }
                is Resource.Failed -> {
                    FavouritesErrorState()
                }
            }
        }
    }
}

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Preview
@Composable
fun FavouritesScreenPreview() {
    FavouritesScreen()
}
