package uk.co.jamiecruwys.compose.playground.ui.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uk.co.jamiecruwys.navigation.FavouritesDirections
import uk.co.jamiecruwys.navigation.FeedDirections
import uk.co.jamiecruwys.navigation.ProfileDirections

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun MainScreenNavHost(
    navController: NavHostController,
    articleScreen: @Composable (NavBackStackEntry) -> Unit,
    favouritesScreen: @Composable (NavBackStackEntry) -> Unit,
    profileScreen: @Composable (NavBackStackEntry) -> Unit,
    articleDetailScreen: @Composable (NavBackStackEntry) -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = FeedDirections.root.route,
    ) {
        composable(FeedDirections.root.route, content = articleScreen)
        composable(FeedDirections.detail.route, content = articleDetailScreen)
        composable(FavouritesDirections.root.route, content = favouritesScreen)
        composable(ProfileDirections.root.route, content = profileScreen)
    }
}
