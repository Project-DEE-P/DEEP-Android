package com.example.app.presentation.screen.login.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.di.HiltApplication
import com.example.app.presentation.screen.signup.state.SignupState
import com.example.domain.model.user.LoginRequestModel
import com.example.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {

    private var _loginState = MutableStateFlow(SignupState())
    val loginState: StateFlow<SignupState> = _loginState

    fun login(loginRequestModel: LoginRequestModel) = viewModelScope.launch {
        kotlin.runCatching {
            userRepository.login(loginRequestModel)
        }.onSuccess {
            Log.d(TAG, "login: success!! $it")
            _loginState.emit(SignupState(isSuccess = true))
            HiltApplication.pref.autoLogin = true
            HiltApplication.pref.accessToken = it.token
            HiltApplication.pref.refreshToken = it.refreshToken
        }.onFailure { e ->
            Log.d(TAG, "login: failed.. $e")
            _loginState.emit(SignupState(error = "$e"))
        }
    }

    companion object {
        private const val TAG = "LoginViewModel"
    }
}