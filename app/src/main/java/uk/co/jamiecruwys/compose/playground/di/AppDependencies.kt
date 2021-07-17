package uk.co.jamiecruwys.compose.playground.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uk.co.jamiecruwys.compose.playground.data.ArticleService
import uk.co.jamiecruwys.compose.playground.data.MockNetworkArticlesService
import uk.co.jamiecruwys.compose.playground.data.NetworkArticleRepository
import uk.co.jamiecruwys.compose.playground.domain.ArticleRepository

@Module
@InstallIn(SingletonComponent::class)
interface AppDependencies {

    @Binds
    fun articleRepository(impl: NetworkArticleRepository): ArticleRepository

    @Binds
    fun articlesService(impl: MockNetworkArticlesService): ArticleService
}
