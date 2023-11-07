package com.example.app.presentation.screen.putnfc

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.util.TAG
import com.example.domain.model.card.CardDto
import com.example.domain.model.card.PostCardModel
import com.example.domain.repository.CardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PutNfcViewModel @Inject constructor(
    private val cardRepository: CardRepository
): ViewModel() {

    var cardList by mutableStateOf<List<CardDto>?>(null)


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

}