package uk.co.jamiecruwys.navigation

import androidx.navigation.compose.NamedNavArgument

object ArticleDirections {
    val root = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "article"
    }

    val detail = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "articleDetail"
    }

    val Default = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = ""
    }
}
