package uk.co.jamiecruwys.compose.playground.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import uk.co.jamiecruwys.compose.playground.Article
import uk.co.jamiecruwys.compose.playground.R

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun ArticleFeed(
    data: Map<String?, List<Article>>,
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        val listState = rememberLazyListState()
        val scope = rememberCoroutineScope()

        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(
                bottom = dimensionResource(id = R.dimen.article_feed_content_padding_bottom)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .testTag("ArticleFeed")
        ) {
            data.forEach { (year, articles) ->
                year?.let {
                    stickyHeader {
                        ArticleYearHeader(it, Modifier.fillParentMaxWidth())
                    }
                }

                items(articles) { article ->
                    ArticleItem(
                        article,
                        Modifier.fillMaxWidth()
                    )
                }
            }
        }

        val showButton = listState.firstVisibleItemIndex > 0

        AnimatedVisibility(
            visible = showButton,
            enter = fadeIn(),
            exit = fadeOut(),
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            ScrollToTopButton(
                modifier = Modifier.padding(
                    start = dimensionResource(id = R.dimen.article_feed_scroll_to_top_button_padding_horizontal),
                    end = dimensionResource(id = R.dimen.article_feed_scroll_to_top_button_padding_horizontal),
                    top = dimensionResource(id = R.dimen.article_feed_scroll_to_top_button_padding_top),
                    bottom = dimensionResource(id = R.dimen.article_feed_scroll_to_top_button_padding_bottom),
                )
            ) {
                scope.launch {
                    listState.animateScrollToItem(0)
                }
            }
        }
    }
}

@Preview
@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun ArticleFeedPreview() {
    ArticleFeed(
        mapOf(
            Pair(
                null,
                listOf(
                    Article(
                        title = "One title",
                        subtitle = "One subtitle",
                        date = "December 2016",
                        year = 2016
                    ),
                    Article(
                        title = "One title",
                        subtitle = "One subtitle",
                        date = "December 2016",
                        year = 2016
                    ),
                    Article(
                        title = "Two title",
                        subtitle = "Two subtitle",
                        date = "December 2017",
                        year = 2017
                    ),
                ),
            )
        )
    )
}