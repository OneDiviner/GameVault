package com.example.impl.presentation.home.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.impl.presentation.contract.HomeState

internal class HomeStateProvider: PreviewParameterProvider<HomeState> {
    override val values = sequenceOf(
        HomeState(isLoading = true),
        HomeState(error = "Some message"),
        HomeState(games = GameMockData.gameItemsList),
    )
}