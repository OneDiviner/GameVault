package com.example.gamevault.di

import com.example.network.di.ktorClientModule
import org.koin.dsl.module

val sharedModule = module {
    includes(
        ktorClientModule
    )
}