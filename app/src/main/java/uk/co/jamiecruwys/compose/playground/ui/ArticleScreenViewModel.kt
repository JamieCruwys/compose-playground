package uk.co.jamiecruwys.compose.playground.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uk.co.jamiecruwys.compose.playground.domain.Article
import uk.co.jamiecruwys.compose.playground.domain.ArticleFilter
import uk.co.jamiecruwys.compose.playground.domain.LoadArticlesInteractor
import uk.co.jamiecruwys.compose.playground.domain.Resource
import javax.inject.Inject

@HiltViewModel
class ArticleScreenViewModel @Inject constructor(
    private val interactor: LoadArticlesInteractor
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
            loadArticles().collect {
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

    suspend fun loadArticles() = interactor.loadArticles()
}
