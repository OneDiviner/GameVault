package com.example.impl.presentation.components.listitem

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.designsystem.Colors
import com.example.designsystem.Shapes
import com.example.designsystem.Spacings
import com.example.designsystem.Typography
import com.example.impl.domain.model.Game
import com.example.impl.domain.model.PlatformGroup
import com.example.impl.presentation.components.listitem.pager.ImagePager
import com.example.impl.presentation.components.listitem.pager.PagerPosition
import com.example.impl.presentation.model.GameItemState
import com.example.impl.presentation.utils.toIcon
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun GameItem(
    modifier: Modifier = Modifier,
    gameState: GameItemState,
    onClick: () -> Unit,
    onAppear: (Int) -> Unit
) {

    LaunchedEffect(key1 = gameState.game.id) {
        onAppear(gameState.game.id)
    }

    val pagerState = rememberPagerState(pageCount = { gameState.images.size })

    Column (
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Colors.surface,
                shape = RoundedCornerShape(Shapes.extraLarge)
            )
            .clip(RoundedCornerShape(Shapes.extraLarge))
            .clickable(
                enabled = true
            ) {
                onClick()
            }
            /*.border(
                width = 1.dp,
                color = Colors.border,
                shape = RoundedCornerShape(Shapes.extraLarge)
            )*/
            .padding(vertical = Spacings.small),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImagePager(
            modifier = Modifier,
            pagerState = pagerState,
            images = gameState.images,
            onImageClick = onClick
        )
        /*RatingBadge(
            modifier = Modifier
                .padding(
                    vertical = Spacings.medium,
                    horizontal = Spacings.extraLarge
                ),
            rating = gameState.game.metacritic
        )*/
        PagerPosition(
            modifier = Modifier
                .padding(Spacings.small),
            pageCount = pagerState.pageCount,
            currentPage = pagerState.currentPage
        )
        Column(
            modifier = Modifier
                .padding(vertical = Spacings.small, horizontal = Spacings.medium)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(Spacings.extraSmall)
        ) {
            Text(
                modifier = Modifier,
                text = gameState.game.name,
                style = Typography.titleMedium,
                color = Colors.onBackground,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(Spacings.extraSmall)
            ) {
                gameState.game.platformsGroup.forEach { platform ->
                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(platform.id.toIcon()),
                        contentDescription = null,
                        tint = Colors.onBackground.copy(0.7f) //FIXME: Check about copy
                    )
                }
            }
        }
    }
}

@Composable
@Preview
private fun GameItemPreview() {
    GameItem(
        gameState = GameItemState(
            game = Game(
                id = 2,
                name = "Cyberpunk 2077",
                backgroundImage = "https://api.rawg.io/media/games/26d/26d443e1e5defa9fb693b95df1344ade.jpg",
                metacritic = "86",
                platformsGroup = listOf(
                    PlatformGroup.PC,
                    PlatformGroup.PLAYSTATION,
                    PlatformGroup.XBOX
                )
            )
        ),
        onClick = { },
        onAppear = { }
    )
}