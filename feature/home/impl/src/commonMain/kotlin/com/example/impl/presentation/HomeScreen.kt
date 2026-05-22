package com.example.impl.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.displayCutoutPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.impl.presentation.components.GameListItem
import com.example.impl.presentation.components.GamesList
import com.example.impl.presentation.components.SearchTextField
import com.example.impl.presentation.contract.HomeIntent
import com.example.impl.presentation.contract.HomeSideEffect
import gamevault.core.resource.generated.resources.Res
import gamevault.core.resource.generated.resources.gamepad_icon
import gamevault.core.resource.generated.resources.logo_icon
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect

@Composable
fun HomeFeature(
    paddingValues: PaddingValues
) { //DANGER: Think about how to build navigation to keep the modules isolated
    HomeScreen(
        paddingValues = paddingValues
    )
}

@Composable
internal fun HomeScreen(
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .displayCutoutPadding()
            .padding(paddingValues),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier.size(32.dp),
                painter = painterResource(Res.drawable.logo_icon),
                tint = MaterialTheme.colorScheme.onBackground,
                contentDescription = null
            )
            Text(
                modifier = Modifier,
                text = "GameVault",
                style = MaterialTheme.typography.titleMedium
            )
        }

        SearchTextField(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            onSearchButtonCLick = {
                viewModel.dispatch(HomeIntent.SearchGames(it)) //FIXME: Check is this correct
            }
        )

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
                    modifier = Modifier,
                    gamesList = state.games,
                    onGameListItemClick = {  }
                )
            }
        }
    }
}