package uk.co.jamiecruwys.compose.playground.repository

import uk.co.jamiecruwys.compose.playground.Article
import javax.inject.Inject

open class ArticleRepository @Inject constructor() {
    open fun getArticles(): List<Article> = listOf(
        Article(
            title = "One title",
            subtitle = "One subtitle",
            date = "December 2016",
            year = 2016
        ),
        Article(
            title = "Two title",
            subtitle = "Two subtitle",
            date = "December 2016",
            year = 2016
        ),
        Article(
            title = "Three title",
            subtitle = "Three subtitle",
            date = "December 2017",
            year = 2017
        ),
        Article(
            title = "Four title",
            subtitle = "Four subtitle",
            date = "December 2018",
            year = 2018
        ),
        Article(
            title = "Five title",
            subtitle = "Five subtitle",
            date = "December 2018",
            year = 2018
        ),
        Article(
            title = "Six title",
            subtitle = "Six subtitle",
            date = "December 2019",
            year = 2019
        ),
        Article(
            title = "Seven title",
            subtitle = "Seven subtitle",
            date = "December 2020",
            year = 2020
        ),
    )
}
