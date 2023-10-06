package com.example.domain.repository

import com.example.domain.model.user.GoogleOauthRequestModel
import com.example.domain.model.user.GoogleOauthResponseModel
import com.example.domain.model.user.LoginRequestModel
import com.example.domain.model.user.LoginResponseModel
import okhttp3.Response
import okhttp3.ResponseBody

interface UserRepository {

//    suspend fun googleOauthLogin(): GoogleOauthResponseModel
    suspend fun googleOauthLogin(
        googleOauthRequestModel: GoogleOauthRequestModel
    ): GoogleOauthResponseModel

    suspend fun login(
        loginRequestModel: LoginRequestModel
    ): LoginResponseModel

}