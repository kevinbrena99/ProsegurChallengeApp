package com.example.prosegurchallengeapp.presentation.common

/**
 * Created by Kevin Breña on 02/09/2023.
 * Prosegur App
 *
 * kevin.brena99@gmail.com
 * Lima, Perú
 **/
sealed class UiState<out T> {
    object Init: UiState<Nothing>()
    data class IsLoading(val isLoading: Boolean): UiState<Nothing>()
    data class Error(val message: String): UiState<Nothing>()
    data class Success<T>(val data: T): UiState<T>()
}
