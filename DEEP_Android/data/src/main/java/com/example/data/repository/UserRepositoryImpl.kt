package com.example.data.repository

import com.example.data.mapper.toModel
import com.example.data.remote.api.UserApi
import com.example.domain.model.user.GoogleOauthResponseModel
import com.example.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApi
): UserRepository {

    override suspend fun googleOauthLogin(): GoogleOauthResponseModel =
        userApi.googleOauthLogin().data.toModel()

}