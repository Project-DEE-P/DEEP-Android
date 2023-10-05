package com.example.domain.repository

import com.example.domain.model.user.GoogleOauthResponseModel

interface UserRepository {

    suspend fun googleOauthLogin(): GoogleOauthResponseModel

}