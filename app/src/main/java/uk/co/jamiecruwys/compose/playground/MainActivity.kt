package uk.co.jamiecruwys.compose.playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import uk.co.jamiecruwys.compose.playground.repository.ArticleRepository
import uk.co.jamiecruwys.compose.playground.view.ArticleFeed

class MainActivity : AppCompatActivity() {
    private val repository: ArticleRepository = ArticleRepository()

    @ExperimentalAnimationApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticleFeed(
                articles = repository.getArticles()
            )
        }
    }
}
