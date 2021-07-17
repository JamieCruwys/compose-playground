package uk.co.jamiecruwys.compose.playground.data

import uk.co.jamiecruwys.compose.playground.domain.Article

interface ArticleService {
    suspend fun articles(): List<Article>
}
