package com.example.data.mapper

import com.example.data.remote.dto.GoogleOauthResponseDto
import com.example.domain.model.user.GoogleOauthResponseModel

fun GoogleOauthResponseDto.toModel() = GoogleOauthResponseModel(
    token = this.token,
    refreshToken = this.refreshToken
)