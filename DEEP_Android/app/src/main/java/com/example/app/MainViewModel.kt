package com.example.app

import android.content.Intent
import android.graphics.Bitmap
import android.nfc.NfcAdapter
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.*
import com.example.domain.model.card.CardDto
import com.example.domain.repository.CardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val cardRepository: CardRepository
): ViewModel() {

    var isConnected = false
    var text by mutableStateOf("NFC가 연결되지 않았습니다")
    var textColor by mutableStateOf(Color.Red)
    var isButtonEnabled by mutableStateOf(false)

    val successEvent = MutableSharedFlow<Boolean>()

    var isFail = false
    var isSuccessed : Boolean? by mutableStateOf(null)

    var nfcAdapter : NfcAdapter? = null

    var intent : Intent? = null

    var bitmap : Bitmap? by mutableStateOf(null)

    var selectedCard : CardDto? by mutableStateOf(null)

//    fun getCardList() = viewModelScope.launch(Dispatchers.IO) {
//        kotlin.runCatching {
//            cardRepository.getCardList()
//        }.onSuccess {
//            event(Event.SuccessGetCardList(it))
//        }.onFailure {
//            event(Event.UnknownException(it))
//        }
//    }
//
//    fun postCard(image : MultipartBody.Part) = viewModelScope.launch(Dispatchers.IO) {
//        kotlin.runCatching {
//            cardRepository.postCard(image)
//        }.onSuccess {
//            event(Event.SuccessPostCard)
//        }.onFailure {
//            event(Event.UnknownException(it))
//        }
//    }



    fun updateIsConnected(isConnected : Boolean){
        this.isConnected = isConnected
        isButtonEnabled = isConnected
        if(isConnected){
            text = "NFC가 연결되었습니다"
            textColor = Color.Gray
        }
        else {
            text = "NFC가 연결되지 않았습니다"
            textColor = Color.Red
        }
    }



}