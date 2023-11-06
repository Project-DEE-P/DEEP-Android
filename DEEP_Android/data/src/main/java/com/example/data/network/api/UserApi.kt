package com.example.data.network.api

import com.example.data.network.response.Response
import com.example.data.network.request.GoogleOauthRequestDto
import com.example.data.network.response.GoogleOauthResponseDto
import com.example.domain.model.user.LoginRequestModel
import com.example.domain.model.user.LoginResponseModel
import com.example.domain.model.user.SignupRequestModel
import com.example.domain.model.user.SignupResponseModel
import retrofit2.http.Body
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

    @POST("/v1/api/auth/signup")
    suspend fun signup(
        @Body signupRequestModel: SignupRequestModel
    ): SignupResponseModel

}