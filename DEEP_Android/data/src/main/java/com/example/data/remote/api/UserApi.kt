package com.example.data.remote.api

import com.example.data.remote.dto.Response
import com.example.data.remote.dto.user.GoogleOauthRequestDto
import com.example.data.remote.dto.user.GoogleOauthResponseDto
import com.example.data.remote.dto.user.LoginRequestDto
import com.example.data.remote.dto.user.LoginResponseDto
import com.example.domain.model.user.LoginRequestModel
import com.example.domain.model.user.LoginResponseModel
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {

    @POST("/v1/api/auth/google/")
    suspend fun googleOauthLogin(
        @Body googleOauthRequestDto: GoogleOauthRequestDto
    ): Response<GoogleOauthResponseDto>

    @POST("/v1/api/auth/login")
    suspend fun login(
        @Body loginRequestModel: LoginRequestModel
    ): Response<LoginResponseModel>

}