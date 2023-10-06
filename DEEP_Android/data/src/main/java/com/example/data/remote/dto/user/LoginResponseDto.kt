package com.example.data.remote.dto.user

data class LoginResponseDto(
    val token: String,
    val refreshToken: String
)