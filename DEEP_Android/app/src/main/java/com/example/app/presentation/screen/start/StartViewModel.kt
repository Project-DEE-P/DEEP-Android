package com.example.app.presentation.screen.start

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {

    fun googleOauthLogin() = viewModelScope.launch {
        kotlin.runCatching {
            userRepository.googleOauthLogin()
        }.onSuccess {
            Log.d(TAG, "googleOauthLogin: success!!")
        }.onFailure {
            Log.d(TAG, "googleOauthLogin: failed..")
        }
    }

    companion object {
        private const val TAG = "StartViewModel"
    }
}