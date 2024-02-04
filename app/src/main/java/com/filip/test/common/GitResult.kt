package com.filip.test.common

sealed class GitResult<out T> {
    data class Loading<out T>(val data: T? = null) : GitResult<T>()
    data class Success<out T>(val data: T) : GitResult<T>()
    data class Error<out T>(val error: Throwable) : GitResult<T>()
}