package com.example.data.remote.dto

data class Response<T>(
    val status: Int,
    val message: String,
    val data: T
)