package com.example.app.presentation.screen.signup.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.presentation.screen.signup.state.SignupState
import com.example.domain.model.user.SignupRequestModel
import com.example.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {

    private var _signupState = MutableStateFlow(SignupState())
    val signupState: StateFlow<SignupState> = _signupState

    fun signup(signupRequestModel: SignupRequestModel) = viewModelScope.launch {
        kotlin.runCatching {
            userRepository.signup(signupRequestModel)
        }.onSuccess {
            Log.d(TAG, "signup: success!! $it")
            _signupState.emit(SignupState(isSuccess = true))
        }.onFailure { e ->
            Log.d(TAG, "signup: failed.. $e")
            _signupState.emit(SignupState(error = "$e"))
        }
    }

    companion object {
        private const val TAG = "SignupViewModel"
    }

}