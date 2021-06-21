package net.demo.ip.api.domain

sealed class ResultObj<out T: Any> {
    data class Success<out T : Any>(val data: T) : ResultObj<T>()
    data class Error(val exception: Exception) : ResultObj<Nothing>()
}