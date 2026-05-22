package com.example.impl.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import gamevault.core.resource.generated.resources.Res
import gamevault.core.resource.generated.resources.gamepad_icon
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun GameListItemImage(
    modifier: Modifier = Modifier,
    backgroundImage: String,
    metacriticRating: String
) {
    SubcomposeAsyncImage(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .clip(RoundedCornerShape(16.dp)),
        model = backgroundImage,
        contentDescription = null,
        loading = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.surfaceContainer)
            )
        },
        error = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.surfaceContainer)
                    .padding(8.dp)
            ) {
                Icon(
                    modifier = Modifier
                        .fillMaxSize(0.7f)
                        .align(Alignment.Center),
                    painter = painterResource(Res.drawable.gamepad_icon),
                    contentDescription = null
                )
            }
        },
        success = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Transparent),
            ) {
                Image(
                    painter = it.painter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(color = Color(0xFF4CAF82), RoundedCornerShape(8.dp)) //FIXME: Correct get of success color
                        .size(width = 48.dp, height = 24.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .align(Alignment.TopEnd)
                ) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.Center),
                        text = metacriticRating,
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onPrimary,
                    )

                }
            }
        }
    )
}