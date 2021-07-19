package uk.co.jamiecruwys.compose.playground

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import dagger.hilt.android.AndroidEntryPoint
import uk.co.jamiecruwys.compose.playground.ui.article.ArticleScreen
import uk.co.jamiecruwys.compose.playground.viewmodel.ArticleScreenViewModel
import uk.co.jamiecruwys.compose.playground.ui.favourite.FavouritesScreen
import uk.co.jamiecruwys.compose.playground.ui.main.MainScreen
import uk.co.jamiecruwys.compose.playground.ui.theme.PlaygroundTheme
import uk.co.jamiecruwys.compose.playground.ui.profile.ProfileScreen

@Suppress("ForbiddenComment")
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    /**
     * TODO: work out why it crashes when I remove this and make it use the default param
     * in ArticleScreen to get the view model.
     */
    private val articleScreenViewModel: ArticleScreenViewModel by viewModels()

    @ExperimentalAnimationApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PlaygroundTheme {
                MainScreen(
                    articleScreen = {
                        ArticleScreen(articleScreenViewModel)
                    },
                    favouritesScreen = {
                        FavouritesScreen()
                    },
                    profileScreen = {
                        ProfileScreen()
                    }
                )
            }
        }
    }
}
