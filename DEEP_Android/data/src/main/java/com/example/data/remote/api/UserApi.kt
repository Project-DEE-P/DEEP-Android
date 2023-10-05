package com.example.data.remote.api

import com.example.data.remote.dto.GoogleOauthResponseDto
import com.example.data.remote.dto.Response
import retrofit2.http.GET

interface UserApi {

    @GET("/v1/api/auth/google/")
    suspend fun googleOauthLogin(
    ): Response<GoogleOauthResponseDto>
}