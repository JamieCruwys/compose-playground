package uk.co.jamiecruwys.compose.playground.domain

import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    suspend fun loadArticles(): Flow<Resource<List<Article>>>
}
