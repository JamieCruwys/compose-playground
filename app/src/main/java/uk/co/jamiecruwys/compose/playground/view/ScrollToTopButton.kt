package uk.co.jamiecruwys.compose.playground.view

import androidx.compose.foundation.layout.Box
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import uk.co.jamiecruwys.compose.playground.R

@Composable
fun ScrollToTopButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Box(modifier) {
        FloatingActionButton(onClick = onClick, backgroundColor = Color.Blue) {
            Icon(
                Icons.Filled.ArrowUpward,
                stringResource(R.string.scroll_to_top_content_description),
                tint = Color.White
            )
        }
    }
}

@Preview
@Composable
fun ScrollToTopButtonPreview() {
    ScrollToTopButton {}
}