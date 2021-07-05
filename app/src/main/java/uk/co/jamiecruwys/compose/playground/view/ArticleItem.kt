package uk.co.jamiecruwys.compose.playground.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uk.co.jamiecruwys.compose.playground.Article

@Composable
fun ArticleItem(article: Article) {
    val favourite = remember { mutableStateOf(false) }

    MaterialTheme {
        val typography = MaterialTheme.typography
        Card(
            modifier = Modifier
                .padding(16.dp),
            elevation = 6.dp,
        ) {
            Column {
                Image(
                    painter = painterResource(uk.co.jamiecruwys.compose.playground.R.drawable.header),
                    contentDescription = stringResource(uk.co.jamiecruwys.compose.playground.R.string.image_content_description),
                    modifier = Modifier
                        .height(180.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp)),
                    contentScale = ContentScale.Crop,
                )
                Row {
                    Column(modifier = Modifier
                        .padding(16.dp)
                        .weight(8f)
                    ) {
                        Text(
                            text = article.title,
                            style = typography.h5,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                        )
                        Spacer(Modifier.height(4.dp))
                        Text(
                            text = article.subtitle,
                            style = typography.body2,
                        )
                        Spacer(Modifier.height(4.dp))
                        Text(
                            text = article.date,
                            style = typography.body2,
                        )
                    }
                    Column(modifier = Modifier
                        .padding(8.dp)
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

@Preview
@Composable
fun ArticleItemPreview() {
    ArticleItem(
        Article(
            title = "One title",
            subtitle = "One subtitle",
            date = "December 2016"
        )
    )
}
