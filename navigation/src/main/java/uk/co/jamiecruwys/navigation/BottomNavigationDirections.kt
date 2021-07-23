package uk.co.jamiecruwys.navigation

object BottomNavigationDirections {
    val default = object : NavigationCommand() {
        override val route = ""
    }
    val feed = FeedDirections.root
    val favourites = FavouritesDirections.root
    val profile = ProfileDirections.root
}
