package uk.co.jamiecruwys.compose.playground.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uk.co.jamiecruwys.compose.playground.domain.Article
import uk.co.jamiecruwys.compose.playground.domain.ArticleRepository
import uk.co.jamiecruwys.compose.playground.domain.Resource
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

    companion object {
        const val FAKE_DELAY_MILLIS: Long = 1500
    }
}
