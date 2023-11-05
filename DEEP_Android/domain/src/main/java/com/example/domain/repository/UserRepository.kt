package com.example.domain.repository

import com.example.domain.model.user.GoogleOauthRequestModel
import com.example.domain.model.user.GoogleOauthResponseModel
import com.example.domain.model.user.LoginRequestModel
import com.example.domain.model.user.LoginResponseModel
import com.example.domain.model.Response

interface UserRepository {

    suspend fun googleOauthLogin(
        googleOauthRequestModel: GoogleOauthRequestModel
    ): GoogleOauthResponseModel

    suspend fun login(
        loginRequestModel: LoginRequestModel
    ): LoginResponseModel


}