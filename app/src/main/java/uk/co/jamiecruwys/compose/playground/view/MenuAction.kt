package uk.co.jamiecruwys.compose.playground.view

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import uk.co.jamiecruwys.compose.playground.R

sealed class MenuAction(@StringRes val label: Int, @DrawableRes val icon: Int, val action: () -> Unit) {
    class GroupByYear(action: () -> Unit) : MenuAction(R.string.menu_item_group_by_year, R.drawable.ic_baseline_date_range_24, action)
    class Filter(action: () -> Unit) : MenuAction(R.string.menu_item_filter, R.drawable.ic_baseline_filter_alt_24, action)
    class Empty(action: () -> Unit) : MenuAction(R.string.menu_item_empty, R.drawable.ic_baseline_error_24, action)
}
