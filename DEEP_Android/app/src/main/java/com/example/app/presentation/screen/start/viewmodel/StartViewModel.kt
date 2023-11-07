package com.example.app.presentation.screen.start.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.di.HiltApplication
import com.example.app.presentation.screen.start.state.GoogleOauthState
import com.example.domain.model.user.GoogleOauthRequestModel
import com.example.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {

    private var _googleOauthState = MutableStateFlow(GoogleOauthState())
    val googleOauthState: StateFlow<GoogleOauthState> = _googleOauthState

    fun googleOauthLogin(googleOauthRequestModel: GoogleOauthRequestModel) = viewModelScope.launch {
        kotlin.runCatching {
            userRepository.googleOauthLogin(googleOauthRequestModel)
        }.onSuccess {
            Log.d(TAG, "googleOauthLogin: success!! $it")
            _googleOauthState.emit(GoogleOauthState(isSuccess = true))
            HiltApplication.pref.deleteToken()
            HiltApplication.pref.autoLogin = true
            HiltApplication.pref.accessToken = it.token
            HiltApplication.pref.refreshToken = it.refreshToken
        }.onFailure { e ->
            Log.d(TAG, "googleOauthLogin: failed.. $e")
            _googleOauthState.emit(GoogleOauthState(error = "$e"))
        }
    }

    companion object {
        private const val TAG = "StartViewModel"
    }
}