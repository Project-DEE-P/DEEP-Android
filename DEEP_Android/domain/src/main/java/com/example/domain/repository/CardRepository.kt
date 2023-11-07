package com.example.domain.repository

import com.example.domain.model.card.CardDto
import com.example.domain.model.card.PostCardModel
import okhttp3.MultipartBody

interface CardRepository {

    suspend fun postCard(
        card_image : MultipartBody.Part,
        request : PostCardModel
    )

//    suspend fun rememberCard(
//        id : Int
//    )

    suspend fun getRememberedCardList(

    ) : List<CardDto>?

//    suspend fun getCard(
//        id : Int
//    ) : PostCardModel?

    suspend fun getCardList(

    ) : List<CardDto>?

//    suspend fun deleteCard(
//        id : Int
//    )
}