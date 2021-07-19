package uk.co.jamiecruwys.compose.playground.ui.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uk.co.jamiecruwys.compose.playground.ui.bottomnav.BottomNavigationScreens

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun MainScreenNavHost(
    navController: NavHostController,
    articleScreen: @Composable (NavBackStackEntry) -> Unit,
    favouritesScreen: @Composable (NavBackStackEntry) -> Unit,
    profileScreen: @Composable (NavBackStackEntry) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavigationScreens.Feed.route
    ) {
        composable(BottomNavigationScreens.Feed.route, content = articleScreen)
        composable(BottomNavigationScreens.Favourites.route, content = favouritesScreen)
        composable(BottomNavigationScreens.Profile.route, content = profileScreen)
    }
}