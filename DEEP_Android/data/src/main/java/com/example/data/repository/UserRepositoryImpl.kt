package com.example.data.repository

import com.example.data.mapper.toDto
import com.example.data.mapper.toModel
import com.example.data.network.api.UserApi
import com.example.domain.model.user.GoogleOauthRequestModel
import com.example.domain.model.user.GoogleOauthResponseModel
import com.example.domain.model.user.LoginRequestModel
import com.example.domain.model.user.LoginResponseModel
import com.example.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userApi: UserApi
): UserRepository {

    override suspend fun googleOauthLogin(googleOauthRequestModel: GoogleOauthRequestModel): GoogleOauthResponseModel =
        userApi.googleOauthLogin(googleOauthRequestModel.toDto()).data.toModel()

    override suspend fun login(loginRequestModel: LoginRequestModel): LoginResponseModel =
        userApi.login(loginRequestModel).data

}