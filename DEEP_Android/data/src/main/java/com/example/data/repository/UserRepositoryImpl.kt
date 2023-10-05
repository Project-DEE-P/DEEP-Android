package com.example.data.repository

import com.example.domain.model.user.GoogleOauthResponseModel
import com.example.domain.repository.UserRepository

class UserRepositoryImpl: UserRepository {

    override suspend fun googleOauthLogin(): GoogleOauthResponseModel {
        TODO("Not yet implemented")
    }
}