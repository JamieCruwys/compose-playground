package uk.co.jamiecruwys.compose.playground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import dagger.hilt.android.AndroidEntryPoint
import uk.co.jamiecruwys.compose.playground.view.ArticleScreen

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @ExperimentalAnimationApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticleScreen()
        }
    }
}
