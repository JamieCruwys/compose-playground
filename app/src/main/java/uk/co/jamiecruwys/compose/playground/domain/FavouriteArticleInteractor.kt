package uk.co.jamiecruwys.compose.playground.domain

import kotlinx.coroutines.flow.Flow
import java.util.UUID
import javax.inject.Inject

class FavouriteArticleInteractor @Inject constructor(
    private val repository: ArticleRepository
) {
    suspend fun loadFavourites(): Flow<Resource<List<Article>>> =
        repository.loadFavouriteArticles()

    suspend fun favourite(articleId: UUID): Flow<Resource<Unit>> =
        repository.favouriteArticle(articleId)

    suspend fun unFavourite(articleId: UUID): Flow<Resource<Unit>> =
        repository.unfavouriteArticle(articleId)
}
