package com.example.impl.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.plus
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.graphics.vector.VectorProperty
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.designsystem.Colors
import com.example.designsystem.Shapes
import com.example.designsystem.Spacings
import com.example.impl.domain.model.Game
import com.example.impl.presentation.components.listitem.GameItem
import com.example.impl.presentation.model.GameItemState
import sun.java2d.loops.ProcessPath.drawPath

internal fun Modifier.outlineBorder(
    strokeWidth: Dp,
    cornerRadius: Dp,
    color: Color = Color.White
): Modifier = this.drawWithCache {

    val strokeWidthPx = strokeWidth.toPx()
    val cornerRadiusPx = cornerRadius.toPx()

    onDrawBehind {
        drawRoundRect(
            style = Stroke(strokeWidthPx),
            cornerRadius = CornerRadius(cornerRadiusPx),
            color = color,
        )
    }
}

@Composable
internal fun GamesList(
    modifier: Modifier = Modifier,
    gamesList: List<GameItemState>,
    contentPadding: PaddingValues,
    onGameItemAppear: (Int) -> Unit,
    onGameListItemClick: () -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(top = contentPadding.calculateTopPadding() + Spacings.medium),
        verticalArrangement = Arrangement.spacedBy(Spacings.extraSmall),
    ) {
        items(
            items = gamesList,
            key = { it.game.id },
            contentType = { "game_item" }
        ) { gameState ->
            GameItem(
                gameState = gameState,
                onClick = {},
                onAppear = onGameItemAppear
            )
        }
    }
}

@Composable
@Preview
private fun GameListPreview() {
    GamesList(
        gamesList = emptyList(),
        contentPadding = PaddingValues(0.dp),
        onGameListItemClick = {},
        onGameItemAppear = {}
    )
}