package com.example.app.presentation.screen.cardlist

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.domain.model.CardModel
import com.example.domain.repository.CardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.compose.runtime.*
import androidx.lifecycle.viewModelScope
import com.example.app.util.TAG
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CardListViewModel @Inject constructor(
    private val cardRepository: CardRepository
): ViewModel() {

    var rememberedCardList by mutableStateOf<List<CardModel>?>(null)

    fun getRememberedCardList() = viewModelScope.launch(Dispatchers.IO) {
        kotlin.runCatching {
            cardRepository.getRememberedCardList()
        }.onSuccess {
            rememberedCardList = it
        }.onFailure {
            rememberedCardList = null
            Log.d(TAG, "getRememberedCardList:error - $it ")
        }
    }


}