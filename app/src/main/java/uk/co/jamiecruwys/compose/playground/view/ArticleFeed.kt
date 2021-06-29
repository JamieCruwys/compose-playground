package uk.co.jamiecruwys.compose.playground.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import uk.co.jamiecruwys.compose.playground.Article

@Composable
fun ArticleFeed(articles: List<Article>) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        articles.forEach { article ->
            ArticleItem(article)
        }
    }
}
