package com.example.data.network.response

data class Response<T>(
    val status: Int,
    val message: String,
    val data: T
)