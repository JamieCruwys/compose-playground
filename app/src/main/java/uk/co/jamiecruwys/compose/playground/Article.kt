package uk.co.jamiecruwys.compose.playground

data class Article(
    val title: String,
    val subtitle: String,
    val date: String,
    val year: Int,
    val thumbnail: String? = null
)
