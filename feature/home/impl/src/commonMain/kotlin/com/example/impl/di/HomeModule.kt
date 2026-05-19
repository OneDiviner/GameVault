package com.example.impl.di

import com.example.impl.presentation.HomeViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import org.koin.plugin.module.dsl.viewModel

val homeModule = module {
    includes(
        remoteDataSourceModule,
        repositoryModule,
        useCaseModule,
        viewModelModule
    )
}