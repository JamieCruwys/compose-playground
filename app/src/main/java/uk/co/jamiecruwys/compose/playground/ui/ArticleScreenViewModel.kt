package uk.co.jamiecruwys.compose.playground.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uk.co.jamiecruwys.compose.playground.Article
import uk.co.jamiecruwys.compose.playground.repository.ArticleRepository
import javax.inject.Inject

@HiltViewModel
class ArticleScreenViewModel @Inject constructor(
    private val repository: ArticleRepository
): ViewModel() {
    private val _articles = MutableLiveData<Map<String?, List<Article>>>()
    val articles: LiveData<Map<String?, List<Article>>> = _articles

    init {
        load()
    }

    fun load() {
        val items = mutableMapOf<String?, List<Article>>(
            Pair(null, getArticles())
        )
        _articles.postValue(items)
    }

    fun groupByYear() {
        val articles = repository.getArticles()
        val grouped: Map<String?, List<Article>> = articles.groupBy { it.year.toString() }
        _articles.postValue(grouped)
    }

    fun showEmpty() {
        _articles.postValue(mutableMapOf())
    }

    private fun getArticles() = repository.getArticles()
}
