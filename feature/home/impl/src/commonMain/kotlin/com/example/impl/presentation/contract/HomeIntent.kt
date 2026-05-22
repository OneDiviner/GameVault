package com.example.impl.presentation.contract

internal sealed interface HomeIntent {
    data class SearchGames(val searchQueryValue: String): HomeIntent
}