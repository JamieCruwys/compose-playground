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
import uk.co.jamiecruwys.compose.playground.domain.FavouriteArticleInteractor
import uk.co.jamiecruwys.compose.playground.domain.Resource
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class FavouritesScreenViewModel @Inject constructor(
    private val favouriteArticlesInteractor: FavouriteArticleInteractor,
) : ViewModel() {
    private val _state = MutableLiveData<Resource<Map<String?, List<Article>>>>()
    val state: LiveData<Resource<Map<String?, List<Article>>>> = _state

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            favouriteArticlesInteractor.loadFavourites().collect {
                when (it) {
                    is Resource.Loading -> {
                        _state.postValue(Resource.Loading)
                    }
                    is Resource.Loaded -> {
                        val data: Map<String?, List<Article>> = if (it.data.isEmpty()) {
                            emptyMap()
                        } else {
                            mutableMapOf(
                                Pair(null, it.data)
                            )
                        }
                        _state.postValue(Resource.Loaded(data))
                    }
                    is Resource.Failed -> {
                        _state.postValue(Resource.Failed)
                    }
                }
            }
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
}
