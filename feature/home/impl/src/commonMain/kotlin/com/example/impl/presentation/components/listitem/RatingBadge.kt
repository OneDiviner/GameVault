package com.example.impl.presentation.components.listitem

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.Colors
import com.example.designsystem.Shapes
import com.example.designsystem.Spacings
import com.example.designsystem.Typography

@Composable
internal fun RatingBadge(
    modifier: Modifier = Modifier,
    rating: String
) {
    Text(
        modifier = modifier
            .background(
                color = Colors.surface,
                shape = RoundedCornerShape(Shapes.medium)
            )
            .border(
                width = 1.dp,
                color = Colors.border,
                shape = RoundedCornerShape(Shapes.medium)
            )
            .padding(
                horizontal = Spacings.medium,
                vertical = Spacings.extraSmall
            )
            .clip(RoundedCornerShape(Shapes.medium)),
        text = rating,
        style = Typography.titleSmall,
        color = Colors.onSurface,
    )
}

@Composable
@Preview
private fun RatingBadgePreview() {
    RatingBadge(
        modifier = Modifier,
        rating = "90"
    )
}