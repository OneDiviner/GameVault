package com.example.impl.di

import com.example.impl.domain.usecase.GetGameScreenshotsUseCase
import com.example.impl.domain.usecase.GetGamesUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetGamesUseCase(get()) }
    single { GetGameScreenshotsUseCase(get()) }
}