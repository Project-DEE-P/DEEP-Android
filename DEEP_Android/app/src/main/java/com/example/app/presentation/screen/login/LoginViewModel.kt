package com.example.app.presentation.screen.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.presentation.screen.login.state.LoginState
import com.example.domain.model.user.LoginRequestModel
import com.example.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {

    private var _loginState = MutableStateFlow(LoginState())
    val loginState: StateFlow<LoginState> = _loginState

    fun login(loginRequestModel: LoginRequestModel) = viewModelScope.launch {
        kotlin.runCatching {
            userRepository.login(loginRequestModel)
        }.onSuccess {
            Log.d(TAG, "login: success!! $it")
            _loginState.emit(LoginState(isSuccess = true))
        }.onFailure { e ->
            Log.d(TAG, "login: failed.. $e")
            _loginState.emit(LoginState(error = "$e"))
        }
    }

    companion object {
        private const val TAG = "LoginViewModel"
    }
}