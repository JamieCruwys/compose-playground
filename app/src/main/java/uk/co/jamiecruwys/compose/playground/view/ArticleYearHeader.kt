package uk.co.jamiecruwys.compose.playground.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import uk.co.jamiecruwys.compose.playground.R

@Composable
fun ArticleYearHeader(year: String, modifier: Modifier = Modifier) {
    Box(modifier) {
        Row(
            Modifier
                .background(colorResource(R.color.article_year_header_background))
                .fillMaxWidth()
                .padding(
                    horizontal = dimensionResource(R.dimen.article_year_header_horizontal_padding),
                    vertical = dimensionResource(R.dimen.article_year_header_vertical_padding),
                )
        ) {
            Text(
                year,
                color = colorResource(R.color.article_year_header_text_color),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview
@Composable
fun ArticleYearPreview() {
    ArticleYearHeader("2021")
}
