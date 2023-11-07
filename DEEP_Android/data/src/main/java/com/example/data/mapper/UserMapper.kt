package com.example.data.mapper

import com.example.data.network.request.GoogleOauthRequestDto
import com.example.data.network.response.GoogleOauthResponseDto
import com.example.data.network.request.LoginRequestDto
import com.example.data.network.response.LoginResponseDto
import com.example.domain.model.user.GoogleOauthRequestModel
import com.example.domain.model.user.GoogleOauthResponseModel
import com.example.domain.model.user.LoginRequestModel
import com.example.domain.model.user.LoginResponseModel

fun GoogleOauthResponseDto.toModel() = GoogleOauthResponseModel(
    token = this.token,
    refreshToken = this.refreshToken
)

fun GoogleOauthRequestModel.toDto() = GoogleOauthRequestDto(
    token = this.token
)

fun LoginRequestModel.toDto() = LoginRequestDto(
    userId = this.userId,
    password = this.password
)

fun LoginResponseDto.toModel() = LoginResponseModel(
    token = this.token,
    refreshToken = this.refreshToken
)