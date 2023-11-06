package com.example.domain.repository

import com.example.domain.model.user.GoogleOauthRequestModel
import com.example.domain.model.user.GoogleOauthResponseModel
import com.example.domain.model.user.LoginRequestModel
import com.example.domain.model.user.LoginResponseModel
import com.example.domain.model.Response
import com.example.domain.model.user.SignupRequestModel
import com.example.domain.model.user.SignupResponseModel

interface UserRepository {

    suspend fun googleOauthLogin(
        googleOauthRequestModel: GoogleOauthRequestModel
    ): GoogleOauthResponseModel

    suspend fun login(
        loginRequestModel: LoginRequestModel
    ): LoginResponseModel

    suspend fun signup(
        signupRequestModel: SignupRequestModel
    ): SignupResponseModel

}