package uk.co.jamiecruwys.compose.playground.domain

sealed class Resource<out T> {
    object Loading : Resource<Nothing>()
    object Failed : Resource<Nothing>()
    data class Loaded<D>(val data: D) : Resource<D>()
}
