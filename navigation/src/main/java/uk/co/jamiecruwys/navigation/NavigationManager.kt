package uk.co.jamiecruwys.navigation

import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigationManager @Inject constructor() {
    var commands = MutableStateFlow(BottomNavigationDirections.default)

    fun navigate(directions: NavigationCommand) {
        commands.value = directions
    }
}
