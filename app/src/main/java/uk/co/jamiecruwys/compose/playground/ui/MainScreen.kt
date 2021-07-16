package uk.co.jamiecruwys.compose.playground.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

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

@Composable
fun MainScreenBottomNavigation(
    navController: NavController,
    items: List<BottomNavigationScreens>
) {
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(imageVector = screen.icon, contentDescription = null) },
                label = { Text(stringResource(id = screen.resourceId)) },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

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
