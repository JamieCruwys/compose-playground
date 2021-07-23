package uk.co.jamiecruwys.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.ui.graphics.vector.ImageVector

object ProfileDirections {
    val root = object : NavigationCommand() {
        override val route = "profile"
        override val titleResId: Int = R.string.profile_route
        override val icon: ImageVector = Icons.Filled.AccountCircle
    }
}
