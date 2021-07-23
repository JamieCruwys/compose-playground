package uk.co.jamiecruwys.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Article
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavOptions

object FeedDirections {
    val root = object : NavigationCommand() {
        override val route = "feed"
        override val titleResId: Int = R.string.feed_route
        override val icon: ImageVector = Icons.Filled.Article
    }

    val detail = object : NavigationCommand() {
        override val route = "feedDetail"
        override val options: NavOptions = NavOptions.Builder()
            .setPopUpTo(
                route = root.route,
                inclusive = false
            )
            .build()
    }
}
