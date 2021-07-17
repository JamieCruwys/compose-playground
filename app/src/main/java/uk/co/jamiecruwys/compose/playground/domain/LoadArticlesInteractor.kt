package uk.co.jamiecruwys.compose.playground.domain

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoadArticlesInteractor @Inject constructor(
    private val repository: ArticleRepository
) {
    suspend fun loadArticles(): Flow<Resource<List<Article>>> =
        repository.loadArticles()
}
