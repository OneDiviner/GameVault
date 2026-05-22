package com.example.impl.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.impl.domain.model.Game
import com.example.impl.domain.model.GameScreenshots
import com.example.impl.domain.usecase.GetGameScreenshotsUseCase
import com.example.impl.presentation.utils.toIcon
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.koinInject
import kotlin.onSuccess

@Composable
internal fun GameListItem(
    modifier: Modifier = Modifier,
    game: Game,
    onClick: () -> Unit,
    getGameScreenshotsUseCase: GetGameScreenshotsUseCase = koinInject(),
) {

    var screenshots by remember { mutableStateOf(GameScreenshots(2, emptyList())) }
    var isImageLoading by remember { mutableStateOf(false) }

    LaunchedEffect(game.id) {
        isImageLoading = true
        getGameScreenshotsUseCase(
            gameId = game.id.toString(),
            ordering = null,
            page = 1,
            pageSize = 8
        ).onSuccess {
            screenshots = it
        }.onFailure {

        }
        isImageLoading = false
    }

    val pagerState = rememberPagerState(pageCount = { screenshots.count })

    Card(
        modifier = modifier
            .fillMaxWidth(),
        onClick = {

        },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
    ) {
        HorizontalPager(
            modifier = Modifier,
            state = pagerState,
            pageSpacing = 0.dp,
            beyondViewportPageCount = 1
        ) { page ->

            //TODO: Rework GameListItemImage to reusable component
            if (page == 0) {
                GameListItemImage(
                    modifier = Modifier
                        .padding(top = 8.dp, start = 8.dp, end = 8.dp),
                    backgroundImage = game.backgroundImage,
                    metacriticRating = game.metacritic
                )
            } else {
                if (screenshots.screenshots.isNotEmpty()) {
                    GameListItemImage(
                        modifier = Modifier
                            .padding(top = 8.dp, start = 8.dp, end = 8.dp),
                        backgroundImage = screenshots.screenshots[page-1].image,
                        metacriticRating = game.metacritic
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                modifier = Modifier,
                text = game.name,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onBackground,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                game.platformsGroup.forEach { platform ->
                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(platform.id.toIcon()),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground.copy(0.7f)
                    )
                }
            }
        }
    }
}