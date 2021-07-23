package uk.co.jamiecruwys.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavOptions
import androidx.navigation.compose.NamedNavArgument

abstract class NavigationCommand {
    open val arguments: List<NamedNavArgument> = emptyList()
    abstract val route: String
    @StringRes open val titleResId: Int? = null
    open val icon: ImageVector? = null
    open val options: NavOptions? = null
}
