package uk.co.jamiecruwys.compose.playground.view

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
    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> = _articles

    init {
        load()
    }

    fun load() {
        _articles.postValue(repository.getArticles())
    }
}
