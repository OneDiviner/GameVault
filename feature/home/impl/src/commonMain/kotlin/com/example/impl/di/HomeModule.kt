package com.example.impl.di

import org.koin.dsl.module

val homeModule = module {
    includes(
        remoteDataSourceModule,
        repositoryModule,
        useCaseModule,
        viewModelModule
    )
}