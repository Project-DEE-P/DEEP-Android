package com.example.app

import android.content.Intent
import android.graphics.Bitmap
import android.nfc.NfcAdapter
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.*
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.app.util.TAG
import com.example.domain.model.CardModel
import com.example.domain.repository.CardRepository
import com.ggd.zendee.utils.MutableEventFlow
import com.ggd.zendee.utils.asEventFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
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