package uk.co.jamiecruwys.compose.playground.ui.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import uk.co.jamiecruwys.navigation.BottomNavigationDirections

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun MainScreen(
    navController: NavHostController,
    articleScreen: @Composable (NavBackStackEntry) -> Unit,
    favouritesScreen: @Composable (NavBackStackEntry) -> Unit,
    profileScreen: @Composable (NavBackStackEntry) -> Unit,
    articleDetailScreen: @Composable (NavBackStackEntry) -> Unit,
) {
    val items = listOf(
        BottomNavigationDirections.feed,
        BottomNavigationDirections.favourites,
        BottomNavigationDirections.profile,
    )

    Scaffold(
        bottomBar = {
            MainScreenBottomNavigation(
                navController = navController,
                items = items
            )
        }
    ) {
        MainScreenNavHost(
            navController = navController,
            articleScreen = articleScreen,
            favouritesScreen = favouritesScreen,
            profileScreen = profileScreen,
            articleDetailScreen = articleDetailScreen,
        )
    }
}
