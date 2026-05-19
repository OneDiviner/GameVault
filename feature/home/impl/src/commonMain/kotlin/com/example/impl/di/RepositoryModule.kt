package com.example.impl.di

import com.example.impl.data.repository.HomeRepositoryImpl
import com.example.impl.domain.repository.HomeRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<HomeRepository> { HomeRepositoryImpl(get()) }
}