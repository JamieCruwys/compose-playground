package uk.co.jamiecruwys.compose.playground.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ArticleYearHeader(year: Int, modifier: Modifier = Modifier) {
    Box(modifier) {
        Row(
            Modifier
                .background(Color.Blue)
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Text(
                year.toString(),
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
fun ArticleYearPreview() {
    ArticleYearHeader(2021)
}
