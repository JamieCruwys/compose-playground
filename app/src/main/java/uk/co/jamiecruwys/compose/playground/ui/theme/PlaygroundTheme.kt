package uk.co.jamiecruwys.compose.playground.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import com.google.android.material.composethemeadapter.createMdcTheme

@Composable
fun PlaygroundTheme(
    content: @Composable () -> Unit
) {
    // This uses the material design components theme adapter, which using the styles.xml
    // to create a theme for us. For more information, please visit:
    // https://github.com/material-components/material-components-android-compose-theme-adapter
    val mdcTheme = createMdcTheme(
        context = LocalContext.current,
        layoutDirection = LocalLayoutDirection.current
    )

    val colors: Colors = mdcTheme.colors!!
    val typography: Typography = mdcTheme.typography!!
    val shapes: Shapes = mdcTheme.shapes!!

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
