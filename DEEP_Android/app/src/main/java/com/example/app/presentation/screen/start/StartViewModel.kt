package com.example.app.presentation.screen.start

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.user.GoogleOauthRequestModel
import com.example.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {

    val id = MutableLiveData<String>()
    val email = MutableLiveData<String>()

    fun googleOauthLogin(googleOauthRequestModel: GoogleOauthRequestModel) = viewModelScope.launch {
        kotlin.runCatching {
            userRepository.googleOauthLogin(googleOauthRequestModel)
        }.onSuccess {
            Log.d(TAG, "googleOauthLogin: success!! $it")
        }.onFailure {
            Log.d(TAG, "googleOauthLogin: failed.. $it")
        }
    }

    companion object {
        private const val TAG = "StartViewModel"
    }
}