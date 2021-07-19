package uk.co.jamiecruwys.compose.playground.ui.favourite

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import uk.co.jamiecruwys.compose.playground.R

sealed class FavouritesScreenMenuAction(@StringRes val label: Int, @DrawableRes val icon: Int, val action: () -> Unit) {
    class Refresh(action: () -> Unit) : FavouritesScreenMenuAction(
        R.string.menu_item_refresh,
        R.drawable.ic_baseline_refresh_24,
        action
    )
}
