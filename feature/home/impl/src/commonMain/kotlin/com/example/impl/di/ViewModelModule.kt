package com.example.impl.di

import com.example.impl.presentation.home.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeViewModel(
            getGamesUseCase = get(),
            getGameScreenshotsUseCase = get()
        )
    }
}