package com.example.app.presentation.screen.create

import android.media.Image
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.*
import androidx.lifecycle.viewModelScope
import com.example.app.util.TAG
import com.example.data.network.request.Message
import com.example.domain.model.ClovaOcrDto
import com.example.domain.model.MessageModel
import com.example.domain.repository.CardRepository
import com.example.domain.repository.ClovaOcrRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor(
    private val cardRepository: CardRepository,
    private val clovaOcrRepository: ClovaOcrRepository

): ViewModel() {


    var isSuccess by mutableStateOf<Boolean?>(null)

    var dialogState by mutableStateOf<Boolean>(false)

    var ClovaOcrReault by mutableStateOf<ClovaOcrDto?>(null)
    fun postCard(image : MultipartBody.Part) = viewModelScope.launch(Dispatchers.IO) {
        kotlin.runCatching {
            cardRepository.postCard(image)
        }.onSuccess {
            Log.d(TAG,"CreateViewModel - Success")
            isSuccess = true
        }.onFailure {
            Log.d(TAG,"CreateViewModel - error - $it")
            isSuccess = false
        }
    }

    fun postClovaOcr(
        file : MultipartBody.Part,
        message: MessageModel
    ) = viewModelScope.launch(Dispatchers.IO) {
        kotlin.runCatching {
            clovaOcrRepository.postClovaOcr(file, message)
        }.onSuccess {
            ClovaOcrReault = it
        }.onFailure {
            Log.d(TAG,"postClovaOcr - error - $it")
        }
    }

}