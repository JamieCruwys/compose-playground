package uk.co.jamiecruwys.navigation

import androidx.navigation.compose.NamedNavArgument

object MainScreenDirections {
    val root = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "feed"
    }

    val favourites = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "favourites"
    }

    val profile = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "profile"
    }

    val Default = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = ""
    }
}
