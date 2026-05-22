package com.example.impl.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.impl.domain.model.Game

@Composable
internal fun GamesList(
    modifier: Modifier = Modifier,
    gamesList: List<Game>,
    onGameListItemClick: () -> Unit
) {
    LazyVerticalGrid(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp),
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            gamesList,
            key = { it.id },
            contentType = { "game_item" }
        ) { game ->
            GameListItem(
                game = game,
                onClick = {}
            )
        }
    }
}