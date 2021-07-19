package uk.co.jamiecruwys.compose.playground.data

import uk.co.jamiecruwys.compose.playground.domain.Article
import java.util.UUID

interface ArticleService {
    suspend fun articles(): List<Article>
    suspend fun favourite(articleId: UUID)
    suspend fun unfavourite(articleId: UUID)
    suspend fun favouriteArticles(): List<Article>
}
