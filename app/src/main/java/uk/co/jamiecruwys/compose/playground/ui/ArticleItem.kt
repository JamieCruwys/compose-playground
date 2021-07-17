package uk.co.jamiecruwys.compose.playground.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import uk.co.jamiecruwys.compose.playground.domain.Article
import uk.co.jamiecruwys.compose.playground.R

@Composable
fun ArticleItem(
    article: Article,
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        val favourite = remember { mutableStateOf(false) }

        MaterialTheme {
            val typography = MaterialTheme.typography
            Card(
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.article_item_card_padding)),
                elevation = dimensionResource(R.dimen.article_item_card_elevation),
            ) {
                Column {
                    Image(
                        painter = painterResource(R.drawable.header),
                        contentDescription = stringResource(R.string.image_content_description),
                        modifier = Modifier
                            .height(dimensionResource(R.dimen.article_item_image_height))
                            .fillMaxWidth()
                            .clip(
                                shape = RoundedCornerShape(
                                    topStart = dimensionResource(R.dimen.article_item_top_corner_rounding),
                                    topEnd = dimensionResource(R.dimen.article_item_top_corner_rounding),
                                )
                            ),
                        contentScale = ContentScale.Crop,
                    )
                    Row {
                        Column(modifier = Modifier
                            .padding(dimensionResource(R.dimen.article_item_content_padding))
                            .weight(8f)
                        ) {
                            Text(
                                text = article.title,
                                style = typography.h5,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                            )
                            Spacer(
                                Modifier.height(
                                    dimensionResource(R.dimen.article_item_text_spacer_height)
                                )
                            )
                            Text(
                                text = article.subtitle,
                                style = typography.body2,
                            )
                            Spacer(
                                Modifier.height(
                                    dimensionResource(R.dimen.article_item_text_spacer_height)
                                )
                            )
                            Text(
                                text = article.date,
                                style = typography.body2,
                            )
                        }
                        Column(modifier = Modifier
                            .padding(
                                dimensionResource(R.dimen.article_item_favourite_button_padding)
                            )
                            .weight(2f)
                        ) {
                            FavouriteButton(isChecked = favourite.value) {
                                favourite.value = favourite.value.not()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ArticleItemPreview() {
    ArticleItem(
        Article(
            title = "One title",
            subtitle = "One subtitle",
            date = "December 2016",
            year = 2016
        )
    )
}
