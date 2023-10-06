package com.example.data.mapper

import com.example.data.remote.dto.user.GoogleOauthRequestDto
import com.example.data.remote.dto.user.GoogleOauthResponseDto
import com.example.data.remote.dto.user.LoginRequestDto
import com.example.data.remote.dto.user.LoginResponseDto
import com.example.domain.model.user.GoogleOauthRequestModel
import com.example.domain.model.user.GoogleOauthResponseModel
import com.example.domain.model.user.LoginRequestModel
import com.example.domain.model.user.LoginResponseModel

fun GoogleOauthResponseDto.toModel() = GoogleOauthResponseModel(
    token = this.token,
    refreshToken = this.refreshToken
)

fun GoogleOauthRequestModel.toDto() = GoogleOauthRequestDto(
    id = this.id,
    email = this.email
)

fun LoginRequestModel.toDto() = LoginRequestDto(
    userId = this.userId,
    password = this.password
)

fun LoginResponseDto.toModel() = LoginResponseModel(
    token = this.token,
    refreshToken = this.refreshToken
)