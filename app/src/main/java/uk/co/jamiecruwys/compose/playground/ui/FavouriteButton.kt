package uk.co.jamiecruwys.compose.playground.ui

import android.annotation.SuppressLint
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconToggleButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import uk.co.jamiecruwys.compose.playground.R

@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun FavouriteButton(isChecked: Boolean, onClick: () -> Unit) {
    IconToggleButton(checked = isChecked, onCheckedChange = { onClick() }) {
        val transition = updateTransition(isChecked, label = "Checked indicator")

        val tint by transition.animateColor(
            label = "Tint"
        ) { isChecked ->
            if (isChecked) {
                colorResource(R.color.favourite_button_checked)
            } else {
                colorResource(R.color.favourite_button_unchecked)
            }
        }

        val buttonSize = dimensionResource(R.dimen.favourite_button_size)
        val buttonSize2 = dimensionResource(R.dimen.favourite_button_size_2)
        val buttonSize3 = dimensionResource(R.dimen.favourite_button_size_3)
        val buttonSize4 = dimensionResource(R.dimen.favourite_button_size_4)

        val size by transition.animateDp(
            transitionSpec = {
                if (false isTransitioningTo true) {
                    keyframes {
                        durationMillis = 250
                        buttonSize at 0 with LinearOutSlowInEasing // for 0-15 ms
                        buttonSize2 at 15 with FastOutLinearInEasing // for 15-75 ms
                        buttonSize3 at 75 // ms
                        buttonSize4 at 150 // ms
                    }
                } else {
                    spring(stiffness = Spring.StiffnessVeryLow)
                }
            },
            label = "Size"
        ) {
            buttonSize
        }

        Icon(
            imageVector = if (isChecked) Icons.Filled.Favorite else Icons.Filled.FavoriteBorder,
            contentDescription = null,
            tint = tint,
            modifier = Modifier.size(size)
        )
    }
}

@Preview
@Composable
fun FavoriteButtonPreview() {
    val (isChecked, setChecked) = remember { mutableStateOf(false) }
    MaterialTheme {
        Surface {
            FavouriteButton(
                isChecked = isChecked,
                onClick = { setChecked(!isChecked) }
            )
        }
    }
}
