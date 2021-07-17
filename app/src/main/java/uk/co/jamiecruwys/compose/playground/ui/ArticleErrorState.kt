package uk.co.jamiecruwys.compose.playground.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import uk.co.jamiecruwys.compose.playground.R

@Composable
fun ArticleErrorState(
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Sorry, there has been an error. Please try again.",
                modifier = Modifier.padding(
                    dimensionResource(
                        id = R.dimen.articles_error_content_padding
                    )
                )
            )
        }
    }
}

@Preview
@Composable
fun ArticleErrorStatePreview() {
    ArticleErrorState()
}
