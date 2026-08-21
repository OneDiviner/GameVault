package com.example.impl.presentation.components.listitem.pager

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.Colors

@Composable
internal fun PagerPosition(
    modifier: Modifier = Modifier,
    pageCount: Int,
    currentPage: Int
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pageCount) { index ->
            val dotColor by animateColorAsState(
                targetValue = if (index == currentPage)
                    Colors.onBackground
                else
                    Colors.onBackground.copy(alpha = 0.3f), //FIXME: Remove copy
            )
            Box(
                modifier = Modifier
                    .size(if (index == currentPage) 8.dp else 6.dp)
                    .background(
                        color = dotColor,
                        shape = CircleShape
                    )
            )
        }
    }
}

@Composable
@Preview
private fun PagerPositionPreview() {
    PagerPosition(
        pageCount = 8,
        currentPage = 2
    )
}