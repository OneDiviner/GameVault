package com.example.impl.di

import com.example.impl.data.HomeRemoteDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single { HomeRemoteDataSource(get()) }
}