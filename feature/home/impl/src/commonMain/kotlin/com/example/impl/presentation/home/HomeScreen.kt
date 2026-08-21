package com.example.impl.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import com.example.designsystem.Colors
import com.example.designsystem.Spacings
import com.example.impl.domain.model.Game
import com.example.impl.domain.model.PlatformGroup
import com.example.impl.presentation.components.GamesList
import com.example.impl.presentation.components.topbar.HomeTopBar
import com.example.impl.presentation.contract.HomeSideEffect
import com.example.impl.presentation.contract.HomeState
import com.example.impl.presentation.home.preview.HomeStateProvider
import com.example.impl.presentation.model.GameItemState
import kotlinx.collections.immutable.persistentListOf
import org.koin.compose.viewmodel.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun HomeFeature(
    paddingValues: PaddingValues
) { //DANGER: Think about how to build navigation to keep the modules isolated
    StatefulHomeScreen(
        paddingValues = paddingValues
    )
}
@Composable
internal fun HomeScreen(
    state: HomeState,
    onGameItemAppear: (Int) -> Unit
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .displayCutoutPadding(),
        topBar = {
            HomeTopBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Spacings.medium)
            )
        },
        containerColor = Colors.background
    ) { paddingValues ->
        when {
            state.isLoading -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
            state.error != null -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text("Возникла ошибка", modifier = Modifier.align(Alignment.Center))
                }
            }
            state.games.isEmpty() -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    Text("Ничего не найдено :(", modifier = Modifier.align(Alignment.Center))
                }
            }
            else -> {
                GamesList(
                    modifier = Modifier.fillMaxSize(),
                    gamesList = state.games,
                    contentPadding = PaddingValues(top = paddingValues.calculateTopPadding()),
                    onGameListItemClick = {  },
                    onGameItemAppear = onGameItemAppear
                )
            }
        }
    }
}

@Composable
@Preview
private fun HomeScreenPreview(
    @PreviewParameter(HomeStateProvider::class) state: HomeState
) {
    HomeScreen(
        state = state,
        onGameItemAppear = {}
    )
}