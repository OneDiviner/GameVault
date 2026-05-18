package com.example.network.di

import com.example.network.client.createKtorClient
import org.koin.dsl.module

val ktorClientModule = module {
    single {
        createKtorClient()
    }
}