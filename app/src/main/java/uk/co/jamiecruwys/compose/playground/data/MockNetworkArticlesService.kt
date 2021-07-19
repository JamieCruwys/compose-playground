package uk.co.jamiecruwys.compose.playground.data

import uk.co.jamiecruwys.compose.playground.domain.Article
import java.util.UUID
import javax.inject.Inject

class MockNetworkArticlesService @Inject constructor() : ArticleService {

    override suspend fun articles(): List<Article> = FAKE_DATA

    override suspend fun favourite(articleId: UUID) {
        val item: Article? = FAKE_DATA.find { it.id == articleId }
        item?.favourite = true
    }

    override suspend fun unfavourite(articleId: UUID) {
        val item: Article? = FAKE_DATA.find { it.id == articleId }
        item?.favourite = false
    }

    override suspend fun favouriteArticles(): List<Article> = FAKE_DATA.filter { it.favourite }

    companion object {
        val FAKE_DATA = listOf(
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
}
