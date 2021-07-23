package uk.co.jamiecruwys.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.graphics.vector.ImageVector

object FavouritesDirections {
    val root = object : NavigationCommand() {
        override val route = "favourites"
        override val titleResId: Int = R.string.favourites_route
        override val icon: ImageVector = Icons.Filled.Favorite
    }
}
