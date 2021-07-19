package uk.co.jamiecruwys.compose.playground.domain

import java.util.UUID

data class Article(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val subtitle: String,
    val date: String,
    val year: Int,
    val thumbnail: String? = null,
    var favourite: Boolean = false,
)
