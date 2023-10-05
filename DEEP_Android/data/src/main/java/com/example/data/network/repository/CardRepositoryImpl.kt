package com.example.data.network.repository

import com.example.data.network.api.CardApi
import com.example.data.network.mapper.toModel
import com.example.domain.model.CardModel
import com.example.domain.repository.CardRepository
import okhttp3.MultipartBody
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val cardApi : CardApi
): CardRepository {
    override suspend fun postCard(card_image: MultipartBody.Part): String? =
        cardApi.postCard(card_image).data

    override suspend fun rememberCard(id: Int) {
        cardApi.rememberCard(id)
    }
    override suspend fun getRememberedCardList(): List<CardModel>? =
        cardApi.getRememberedCardList().data?.map { it.toModel() }

    override suspend fun getCard(id: Int): CardModel? =
        cardApi.getCard(id).data?.toModel()

    override suspend fun getCardList(): List<CardModel>? =
        cardApi.getCardList().data?.map { it.toModel() }
}