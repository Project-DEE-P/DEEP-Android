package com.example.domain.repository

import com.example.domain.model.CardModel
import okhttp3.MultipartBody

interface CardRepository {

    suspend fun postCard(
        card_image : MultipartBody.Part
    )

    suspend fun rememberCard(
        id : Int
    )

    suspend fun getRememberedCardList(

    ) : List<CardModel>?

    suspend fun getCard(
        id : Int
    ) : CardModel?

    suspend fun getCardList(

    ) : List<CardModel>?

    suspend fun deleteCard(
        id : Int
    )
}