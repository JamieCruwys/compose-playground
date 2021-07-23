package uk.co.jamiecruwys.compose.playground

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import uk.co.jamiecruwys.compose.playground.ui.article.ArticleScreen
import uk.co.jamiecruwys.compose.playground.ui.favourite.FavouritesScreen
import uk.co.jamiecruwys.compose.playground.ui.item.ArticleItem
import uk.co.jamiecruwys.compose.playground.ui.main.MainScreen
import uk.co.jamiecruwys.compose.playground.ui.profile.ProfileScreen
import uk.co.jamiecruwys.compose.playground.ui.theme.PlaygroundTheme

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @ExperimentalMaterialApi
    @ExperimentalAnimationApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundTheme {
                val navController = rememberNavController()
                MainScreen(
                    navController = navController,
                    articleScreen = {
                        ArticleScreen(navController = navController)
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
