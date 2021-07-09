package uk.co.jamiecruwys.compose.playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.livedata.observeAsState
import dagger.hilt.android.AndroidEntryPoint
import uk.co.jamiecruwys.compose.playground.repository.ArticleRepository
import uk.co.jamiecruwys.compose.playground.view.ArticleFeed
import uk.co.jamiecruwys.compose.playground.view.ArticleScreen
import uk.co.jamiecruwys.compose.playground.view.ArticleScreenViewModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val articleScreenViewModel: ArticleScreenViewModel by viewModels()

    @ExperimentalAnimationApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            articleScreenViewModel.articles.observeAsState().value.let {
                ArticleScreen(it)
            }
        }
    }
}
