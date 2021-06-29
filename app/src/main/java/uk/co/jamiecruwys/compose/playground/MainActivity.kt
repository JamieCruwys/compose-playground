package uk.co.jamiecruwys.compose.playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import uk.co.jamiecruwys.compose.playground.repository.ArticleRepository
import uk.co.jamiecruwys.compose.playground.view.ArticleFeed

class MainActivity : AppCompatActivity() {
    private val repository: ArticleRepository = ArticleRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        R.drawable.header
        setContent {
            ArticleFeed(
                articles = repository.getArticles()
            )
        }
    }
}
