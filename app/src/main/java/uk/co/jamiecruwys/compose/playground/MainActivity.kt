package uk.co.jamiecruwys.compose.playground

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import uk.co.jamiecruwys.compose.playground.ui.article.ArticleScreen
import uk.co.jamiecruwys.compose.playground.ui.favourite.FavouritesScreen
import uk.co.jamiecruwys.compose.playground.ui.item.ArticleItem
import uk.co.jamiecruwys.compose.playground.ui.main.MainScreen
import uk.co.jamiecruwys.compose.playground.ui.profile.ProfileScreen
import uk.co.jamiecruwys.compose.playground.ui.theme.PlaygroundTheme
import uk.co.jamiecruwys.compose.playground.viewmodel.ArticleScreenViewModel
import uk.co.jamiecruwys.compose.playground.viewmodel.FavouritesScreenViewModel
import uk.co.jamiecruwys.navigation.NavigationManager
import javax.inject.Inject

@Suppress("ForbiddenComment")
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    /**
     * TODO: work out why it crashes when I remove this and make it use the default param
     * in ArticleScreen/FavouritesScreen to get the view model.
     */
    private val articleScreenViewModel: ArticleScreenViewModel by viewModels()
    private val favouritesScreenViewModel: FavouritesScreenViewModel by viewModels()

//    @Inject
//    lateinit var navigationManager: NavigationManager

    @ExperimentalMaterialApi
    @ExperimentalAnimationApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundTheme {
                val navController = rememberNavController()
//                navigationManager.commands.collectAsState().value.also { command ->
//                    if (command.destination.isNotEmpty()) {
//                        navController.navigate(command.destination)
//                    }
//                }
                MainScreen(
                    navController = navController,
                    articleScreen = {
                        ArticleScreen(articleScreenViewModel, navController)
                    },
                    favouritesScreen = {
                        FavouritesScreen(favouritesScreenViewModel)
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
