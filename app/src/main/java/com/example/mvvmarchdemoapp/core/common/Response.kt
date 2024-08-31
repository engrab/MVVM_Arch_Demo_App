package com.example.mvvmarchdemoapp.core.common

sealed interface Response<out T> {
    object Loading: Response<Nothing>
    data class Success<T>(val data: T): Response<T>
    data class Error<T>(val errorMessage: String): Response<T>

}