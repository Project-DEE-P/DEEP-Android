package com.example.app.presentation.screen.profile

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.domain.model.card.PostCardModel
import com.example.domain.repository.CardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.*
import androidx.lifecycle.viewModelScope
import com.example.app.util.TAG
import com.example.domain.model.card.CardDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val cardRepository: CardRepository
): ViewModel() {

    var cardList by mutableStateOf<List<CardDto>?>(null)
    var isSuccess by mutableStateOf<Int>(0)

    fun getCardList() = viewModelScope.launch(Dispatchers.IO) {
        kotlin.runCatching {
            cardRepository.getCardList()
        }.onSuccess {
            cardList = it
            Log.d(TAG,"getCardList - $it ")

        }.onFailure {
            cardList = null
            Log.d(TAG, "getCardList:error - $it ")
        }
    }

//    fun deleteCard(id : Int) = viewModelScope.launch(Dispatchers.IO) {
//        kotlin.runCatching {
//            cardRepository.deleteCard(id)
//        }.onSuccess {
//            isSuccess++
//            Log.d(TAG,"deleteCardList - success ")
//
//        }.onFailure {
//            Log.d(TAG, "deleteCardList error - $it ")
//        }
//    }



}