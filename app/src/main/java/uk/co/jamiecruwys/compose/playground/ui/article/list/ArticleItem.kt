package uk.co.jamiecruwys.compose.playground.ui.article.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import uk.co.jamiecruwys.compose.playground.R
import uk.co.jamiecruwys.compose.playground.domain.Article
import uk.co.jamiecruwys.compose.playground.ui.component.FavouriteButton
import java.util.UUID

@Suppress("LongMethod", "MagicNumber")
@Composable
fun ArticleItem(
    article: Article,
    modifier: Modifier = Modifier,
    onFavourite: (UUID) -> Unit = {},
    onUnfavourite: (UUID) -> Unit = {},
) {
    val favourite = remember { mutableStateOf(false) }

    Box(modifier) {
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
                    Column(
                        modifier = Modifier
                            .padding(dimensionResource(R.dimen.article_item_content_padding))
                            .weight(8f)
                    ) {
                        Text(
                            text = article.title,
                            style = MaterialTheme.typography.h5,
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
                            style = MaterialTheme.typography.body2,
                        )
                        Spacer(
                            Modifier.height(
                                dimensionResource(R.dimen.article_item_text_spacer_height)
                            )
                        )
                        Text(
                            text = article.date,
                            style = MaterialTheme.typography.body2,
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(
                                dimensionResource(R.dimen.article_item_favourite_button_padding)
                            )
                            .weight(2f)
                    ) {
                        FavouriteButton(
                            isChecked = favourite.value,
                        ) {
                            val newValue = favourite.value.not()
                            favourite.value = newValue

                            if (newValue) {
                                onFavourite.invoke(article.id)
                            } else {
                                onUnfavourite.invoke(article.id)
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
