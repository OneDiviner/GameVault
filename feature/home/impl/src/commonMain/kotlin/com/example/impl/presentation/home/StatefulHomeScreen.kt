package com.example.impl.presentation.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.example.impl.presentation.contract.HomeSideEffect
import org.koin.compose.viewmodel.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
internal fun StatefulHomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    paddingValues: PaddingValues
) {
    val state by viewModel.collectAsState()

    viewModel.collectSideEffect { sideEffect ->
        when(sideEffect) {
            is HomeSideEffect.ShowError -> {

            }
        }
    }
    HomeScreen(
        state = state,
        onGameItemAppear = {
            viewModel.loadGameItemImages(it)
        }
    )
}
