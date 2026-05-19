package com.example.impl.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.impl.presentation.contract.HomeSideEffect
import org.koin.compose.viewmodel.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun HomeFeature() { //DANGER: Think about how to build navigation to keep the modules isolated
    HomeScreen()
}

@Composable
internal fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel()
) {

    val state by viewModel.collectAsState()

    viewModel.collectSideEffect { sideEffect ->
        when(sideEffect) {
            is HomeSideEffect.ShowError -> {

            }
        }
    }

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
        else -> {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                item {
                    Text("Games")
                }
                items(
                    state.games,
                    key = { it.id }
                ) { game ->
                    Text(
                        text = game.name
                    )
                }
            }
        }
    }
}