package com.example.data.network.repository

import com.example.data.network.api.CardApi
import com.example.data.network.mapper.toModel
import com.example.data.network.request.PostCardRequest
import com.example.domain.model.CardModel
import com.example.domain.repository.CardRepository
import okhttp3.MultipartBody
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val cardApi : CardApi
): CardRepository {
    override suspend fun postCard(card_image: MultipartBody.Part) {
        cardApi.postCard((card_image))
    }
    override suspend fun rememberCard(id: Int) {
        cardApi.rememberCard(id)
    }
    override suspend fun getRememberedCardList(): List<CardModel>? =
        listOf(
            CardModel("","",1,"1","https://www.printrobo.co.kr/cdn/blog/870x531-pb10008.jpg"),
            CardModel("","",2,"2","https://cdn.imweb.me/thumbnail/20210110/de526feef9241.jpg"),
            CardModel("","",3,"3","https://marketplace.canva.com/EAFFtMpKasI/1/0/1600w/canva-%ED%9D%B0%EC%83%89-%EB%B0%B0%EA%B2%BD-%EC%BB%A8%EC%84%A4%ED%8C%85-%ED%9A%8C%EC%82%AC-%EB%AA%85%ED%95%A8-%EB%94%94%EC%9E%90%EC%9D%B8-WY2WrxEPsfE.jpg"),
            CardModel("","",4,"4","https://www.mhsee.com/shop/data/editor/b7d3cb59ed6ddfc1.jpg"),
            )

//        cardApi.getRememberedCardList().data?.map { it.toModel() }

    override suspend fun getCard(id: Int): CardModel? =
        cardApi.getCard(id).data?.toModel()

    override suspend fun getCardList(): List<CardModel>? =
        listOf(
            CardModel("","",1,"1","https://www.printrobo.co.kr/cdn/blog/870x531-pb10008.jpg"),
            CardModel("","",2,"2","https://cdn.imweb.me/thumbnail/20210110/de526feef9241.jpg"),
            CardModel("","",3,"3","https://marketplace.canva.com/EAFFtMpKasI/1/0/1600w/canva-%ED%9D%B0%EC%83%89-%EB%B0%B0%EA%B2%BD-%EC%BB%A8%EC%84%A4%ED%8C%85-%ED%9A%8C%EC%82%AC-%EB%AA%85%ED%95%A8-%EB%94%94%EC%9E%90%EC%9D%B8-WY2WrxEPsfE.jpg"),
            CardModel("","",4,"4","https://www.mhsee.com/shop/data/editor/b7d3cb59ed6ddfc1.jpg"),
        )
//        cardApi.getCardList().data?.map { it.toModel() }

    override suspend fun deleteCard(id: Int) {
        cardApi.deleteCardList(id)
    }


}