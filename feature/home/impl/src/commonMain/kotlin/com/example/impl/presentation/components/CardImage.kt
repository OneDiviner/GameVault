package com.example.impl.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil3.compose.SubcomposeAsyncImage

@Composable
internal fun CardImage(
    modifier: Modifier = Modifier
) {
    SubcomposeAsyncImage(
        modifier = modifier,
        model = "",
        contentDescription = null,
        contentScale = ContentScale.Fit,
        loading = {

        },
        error = {

        },
    )
}

@Composable
internal fun LoadingCardImage(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier

    ) {

    }
}