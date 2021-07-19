package uk.co.jamiecruwys.compose.playground.domain

import kotlinx.coroutines.flow.Flow
import java.util.UUID

interface ArticleRepository {
    suspend fun loadArticles(): Flow<Resource<List<Article>>>
    suspend fun loadFavouriteArticles(): Flow<Resource<List<Article>>>
    fun favouriteArticle(articleId: UUID): Flow<Resource<Unit>>
    fun unfavouriteArticle(articleId: UUID): Flow<Resource<Unit>>
}
