package uk.co.jamiecruwys.compose.playground.ui.bottomnav

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.ui.graphics.vector.ImageVector
import uk.co.jamiecruwys.compose.playground.R

sealed class BottomNavigationScreens(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object Feed : BottomNavigationScreens("Feed", R.string.feed_route, Icons.Filled.Article)
    object Favourites : BottomNavigationScreens("Favourites", R.string.favourites_route, Icons.Filled.Favorite)
    object Profile : BottomNavigationScreens("Profile", R.string.profile_route, Icons.Filled.AccountCircle)
    object ArticleDetail : BottomNavigationScreens("ArticleDetail", R.string.article_detail_route, Icons.Filled.AccountCircle)
}
