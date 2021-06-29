package uk.co.jamiecruwys.compose.playground.repository

import uk.co.jamiecruwys.compose.playground.Article

class ArticleRepository {
    fun getArticles() = listOf(
        Article(
            title = "One title",
            subtitle = "One subtitle",
            date = "December 2016"
        ),
        Article(
            title = "Two title",
            subtitle = "Two subtitle",
            date = "December 2017"
        ),
        Article(
            title = "Three title",
            subtitle = "Three subtitle",
            date = "December 2018"
        ),
        Article(
            title = "Four title",
            subtitle = "Four subtitle",
            date = "December 2019"
        ),
        Article(
            title = "Five title",
            subtitle = "Five subtitle",
            date = "December 2020"
        ),
    )
}
