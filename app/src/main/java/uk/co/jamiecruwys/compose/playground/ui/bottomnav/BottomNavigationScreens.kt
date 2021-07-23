package uk.co.jamiecruwys.compose.playground.ui.bottomnav

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.graphics.vector.ImageVector
import uk.co.jamiecruwys.compose.playground.R

sealed class BottomNavigationScreens(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object Feed : BottomNavigationScreens(
        route = "Feed",
        resourceId = R.string.feed_route,
        icon = Icons.Filled.Article
    )
    object Favourites : BottomNavigationScreens(
        route = "Favourites",
        resourceId = R.string.favourites_route,
        icon = Icons.Filled.Favorite
    )
    object Profile : BottomNavigationScreens(
        route = "Profile",
        resourceId = R.string.profile_route,
        icon = Icons.Filled.AccountCircle
    )
    object ArticleDetail : BottomNavigationScreens(
        route = "ArticleDetail",
        resourceId = R.string.article_detail_route,
        icon = Icons.Filled.AccountCircle
    )
}
