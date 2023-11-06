package com.example.data.network.response

data class LoginResponseDto(
    val token: String,
    val refreshToken: String
)