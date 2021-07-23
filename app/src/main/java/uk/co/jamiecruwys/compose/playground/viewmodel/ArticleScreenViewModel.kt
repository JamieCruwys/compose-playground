package uk.co.jamiecruwys.compose.playground.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import timber.log.Timber
import uk.co.jamiecruwys.compose.playground.domain.Article
import uk.co.jamiecruwys.compose.playground.domain.ArticleFilter
import uk.co.jamiecruwys.compose.playground.domain.FavouriteArticleInteractor
import uk.co.jamiecruwys.compose.playground.domain.LoadArticlesInteractor
import uk.co.jamiecruwys.compose.playground.domain.Resource
import uk.co.jamiecruwys.navigation.FeedDirections
import uk.co.jamiecruwys.navigation.NavigationManager
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class ArticleScreenViewModel @Inject constructor(
    private val loadArticlesInteractor: LoadArticlesInteractor,
    private val favouriteArticlesInteractor: FavouriteArticleInteractor,
    private val navigationManager: NavigationManager,
) : ViewModel() {
    private val _state = MutableLiveData<Resource<Map<String?, List<Article>>>>()
    val state: LiveData<Resource<Map<String?, List<Article>>>> = _state

    init {
        load()
    }

    fun load(
        filter: ArticleFilter = ArticleFilter.NONE
    ) {
        viewModelScope.launch {
            loadArticlesInteractor.loadArticles().collect {
                when (it) {
                    is Resource.Loading -> {
                        _state.postValue(Resource.Loading)
                    }
                    is Resource.Loaded -> {
                        val filteredData = filterData(filter, it.data)
                        _state.postValue(Resource.Loaded(filteredData))
                    }
                    is Resource.Failed -> {
                        _state.postValue(Resource.Failed)
                    }
                }
            }
        }
    }

    private fun filterData(
        filter: ArticleFilter = ArticleFilter.NONE,
        articles: List<Article>?
    ): Map<String?, List<Article>> = when (filter) {
        ArticleFilter.NONE -> {
            mutableMapOf(
                Pair(null, articles ?: emptyList())
            )
        }
        ArticleFilter.YEAR -> {
            articles?.groupBy { article ->
                article.year.toString()
            } ?: mutableMapOf()
        }
        ArticleFilter.EMPTY -> {
            mutableMapOf()
        }
    }

    fun favouriteArticle(articleId: UUID) {
        viewModelScope.launch {
            favouriteArticlesInteractor.favourite(articleId).collect {
                when (it) {
                    is Resource.Loading -> {
                        Timber.d("Favouriting article $articleId")
                    }
                    is Resource.Loaded -> {
                        Timber.d("Favourited article $articleId")
                    }
                    is Resource.Failed -> {
                        Timber.d("Failed to favourite article $articleId")
                    }
                }
            }
        }
    }

    fun unFavouriteArticle(articleId: UUID) {
        viewModelScope.launch {
            favouriteArticlesInteractor.unFavourite(articleId).collect {
                when (it) {
                    is Resource.Loading -> {
                        Timber.d("Unfavouriting article $articleId")
                    }
                    is Resource.Loaded -> {
                        Timber.d("Unfavourited article $articleId")
                    }
                    is Resource.Failed -> {
                        Timber.d("Failed to unfavourite article $articleId")
                    }
                }
            }
        }
    }

    fun onArticleTapped() {
        Timber.d("Article tapped!")
        val direction = FeedDirections.detail
        navigationManager.navigate(direction)
    }
}
