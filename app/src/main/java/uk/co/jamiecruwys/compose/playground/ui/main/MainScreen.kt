package uk.co.jamiecruwys.compose.playground.ui.main

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.compose.rememberNavController
import uk.co.jamiecruwys.compose.playground.ui.bottomnav.BottomNavigationScreens

@ExperimentalFoundationApi
@ExperimentalAnimationApi
@Composable
fun MainScreen(
    articleScreen: @Composable (NavBackStackEntry) -> Unit,
    favouritesScreen: @Composable (NavBackStackEntry) -> Unit,
    profileScreen: @Composable (NavBackStackEntry) -> Unit
) {
    val navController = rememberNavController()
    val items = listOf(
        BottomNavigationScreens.Feed,
        BottomNavigationScreens.Favourites,
        BottomNavigationScreens.Profile,
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
            profileScreen = profileScreen
        )
    }
}
