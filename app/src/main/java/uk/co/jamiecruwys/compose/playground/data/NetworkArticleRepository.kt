package uk.co.jamiecruwys.compose.playground.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uk.co.jamiecruwys.compose.playground.domain.Article
import uk.co.jamiecruwys.compose.playground.domain.ArticleRepository
import uk.co.jamiecruwys.compose.playground.domain.Resource
import java.util.UUID
import javax.inject.Inject

open class NetworkArticleRepository @Inject constructor(
    private val articlesService: ArticleService
) : ArticleRepository {

    override suspend fun loadArticles(): Flow<Resource<List<Article>>> =
        flow {
            emit(Resource.Loading)

            // Fake delay
            kotlinx.coroutines.delay(FAKE_DELAY_MILLIS)

            emit(
                try {
                    Resource.Loaded(articlesService.articles())
                } catch (_: Throwable) {
                    Resource.Failed
                }
            )
        }

    override suspend fun loadFavouriteArticles(): Flow<Resource<List<Article>>> =
        flow {
            emit(Resource.Loading)

            // Fake delay
            kotlinx.coroutines.delay(FAKE_DELAY_MILLIS)

            emit(
                try {
                    Resource.Loaded(articlesService.favouriteArticles())
                } catch (_: Throwable) {
                    Resource.Failed
                }
            )
        }

    override fun favouriteArticle(articleId: UUID): Flow<Resource<Unit>> =
        flow {
            emit(Resource.Loading)

            // Fake delay
            kotlinx.coroutines.delay(FAKE_DELAY_MILLIS)

            emit(
                try {
                    articlesService.favourite(articleId)
                    Resource.Loaded(Unit)
                } catch (_: Throwable) {
                    Resource.Failed
                }
            )
        }

    override fun unfavouriteArticle(articleId: UUID): Flow<Resource<Unit>> =
        flow {
            emit(Resource.Loading)

            // Fake delay
            kotlinx.coroutines.delay(FAKE_DELAY_MILLIS)

            emit(
                try {
                    articlesService.unfavourite(articleId)
                    Resource.Loaded(Unit)
                } catch (_: Throwable) {
                    Resource.Failed
                }
            )
        }

    companion object {
        const val FAKE_DELAY_MILLIS: Long = 1500
    }
}
