package com.example.gamevault.di

import com.example.impl.di.homeModule
import com.example.network.di.ktorClientModule
import org.koin.dsl.module

val sharedModule = module {
    includes(
        ktorClientModule,
        homeModule
    )
}