package com.example.app

import android.content.Intent
import android.nfc.NfcAdapter
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel

class MainViewModel : ViewModel() {

    var isConnected = false
    var text by mutableStateOf("NFC가 연결되지 않았습니다")
    var textColor by mutableStateOf(Color.Red)
    var isButtonEnabled by mutableStateOf(false)

    var isFail = false
    var isSuccessed : Boolean? by mutableStateOf(null)

    var nfcAdapter : NfcAdapter? = null

    var isBitmapRatioOk by mutableStateOf(false)

    var intent : Intent? = null

    fun updateIsConnected(isConnected : Boolean){
        this.isConnected = isConnected
        isButtonEnabled = isConnected && isBitmapRatioOk
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