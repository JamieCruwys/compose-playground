package uk.co.jamiecruwys.compose.playground

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import uk.co.jamiecruwys.compose.playground.ui.article.ArticleScreen
import uk.co.jamiecruwys.compose.playground.ui.favourite.FavouritesScreen
import uk.co.jamiecruwys.compose.playground.ui.item.ArticleItem
import uk.co.jamiecruwys.compose.playground.ui.main.MainScreen
import uk.co.jamiecruwys.compose.playground.ui.profile.ProfileScreen
import uk.co.jamiecruwys.compose.playground.ui.theme.PlaygroundTheme
import uk.co.jamiecruwys.navigation.NavigationManager
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var navigationManager: NavigationManager

    @ExperimentalMaterialApi
    @ExperimentalAnimationApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundTheme {
                val navController = rememberNavController()
                navigationManager.commands.collectAsState().value.also { command ->
                    Timber.d("Received command ${command.route}")
                    if (command.route.isNotEmpty()) {
                        Timber.d("Executing command ${command.route}")
                        navController.navigate(command.route, command.options)
                    }
                }

                MainScreen(
                    navController = navController,
                    articleScreen = {
                        ArticleScreen()
                    },
                    favouritesScreen = {
                        FavouritesScreen()
                    },
                    profileScreen = {
                        ProfileScreen()
                    },
                    articleDetailScreen = {
                        ArticleItem()
                    }
                )
            }
        }
    }
}
