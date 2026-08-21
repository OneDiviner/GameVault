package com.example.impl.presentation.components.listitem.pager

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.Shapes
import com.example.designsystem.Spacings
import com.example.impl.presentation.components.listitem.CardImage

@Composable
internal fun ImagePager(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    images: List<String>,
    onImageClick: () -> Unit
) {
    HorizontalPager(
        modifier = modifier,
        state = pagerState,
        pageSpacing = Spacings.small,
        contentPadding = PaddingValues(horizontal = Spacings.small),
        beyondViewportPageCount = 1
    ) { page ->
        CardImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(4f / 3f)
                .clip(RoundedCornerShape(Shapes.extraLarge)),
            image = images[page],
            onClick = onImageClick
        )
    }
}

@Composable
@Preview
private fun ImagePagerPreview() {
    ImagePager(
        images = listOf("", "", ""),
        pagerState = rememberPagerState(0, pageCount = { 3 }),
        onImageClick = {}
    )
}