package com.example.impl.presentation.contract

internal sealed interface HomeSideEffect {
    data class ShowError(val message: String): HomeSideEffect
}