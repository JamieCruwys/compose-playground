package uk.co.jamiecruwys.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import uk.co.jamiecruwys.navigation.ArticleDirections.Default

class NavigationManager {
    var commands = MutableStateFlow(Default)

    fun navigate(directions: NavigationCommand) {
        commands.value = directions
    }
}
