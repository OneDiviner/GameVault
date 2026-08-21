package com.example.impl.presentation.components.listitem

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import com.example.designsystem.Colors
import com.example.designsystem.Icons
import com.example.designsystem.Shapes
import com.example.impl.presentation.components.outlineBorder
import org.jetbrains.compose.resources.painterResource

@Composable
internal fun CardImage(
    modifier: Modifier = Modifier,
    image: String,
    onClick: () -> Unit
) {
    SubcomposeAsyncImage(
        modifier = modifier.clickable(
            enabled = true,
            onClick = onClick
        ),
        model = image,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        loading = { LoadingCardImage() },
        error = { ErrorCardImage() },
    )
}

@Composable
internal fun LoadingCardImage(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Colors.surface),
    )
}

@Composable
internal fun ErrorCardImage(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Colors.onSurface.copy(0.1f)),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier
                .fillMaxSize(0.7f),
            painter = painterResource(Icons.gamepad),
            tint = Colors.onSurface, //FIXME: To static color
            contentDescription = null
        )
    }
}

@Composable
@Preview
private fun CardImagePreview() {
    CardImage(
        modifier = Modifier.fillMaxSize(),
        image = "",
        onClick = {}
    )
}