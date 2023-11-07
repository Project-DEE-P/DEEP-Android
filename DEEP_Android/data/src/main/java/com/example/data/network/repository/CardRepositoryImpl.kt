package com.example.data.network.repository

import com.example.data.network.api.CardApi
import com.example.data.network.mapper.toDto
import com.example.data.network.mapper.toRequest
import com.example.data.network.request.PostCardRequest
import com.example.data.network.response.CardResponse
import com.example.domain.model.card.CardDto
import com.example.domain.model.card.PostCardModel
import com.example.domain.repository.CardRepository
import okhttp3.MultipartBody
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val cardApi : CardApi
): CardRepository {
    override suspend fun postCard(card_image: MultipartBody.Part, request: PostCardModel) {
        cardApi.postCard(
            card_image,
            request.toRequest()
        )
    }

    override suspend fun getRememberedCardList(): List<CardDto>? {

//        val list = mutableListOf<CardDto>()
//
//        val imageList = cardApi.getRememberedCardList().data?.map { it.toDto() }
//        val templeteList = cardApi.getRememberedTempleteCardList().data?.map { it.toDto() }
//
//        if(imageList == null && templeteList == null){
//            return null
//        }
//
//        if(imageList != null){
//            list.addAll(imageList)
//        }
//
//        if(templeteList != null){
//            list.addAll(templeteList)
//        }
//
//        return list

        val list = listOf<CardDto>(
            CardDto(false,1,"1","최희건, CHOI HEE GUN","DGSW","","Android Developer","010-3159-4631","053-783-6664","nakim3159@gmail.com,nakim3159@dgsw.hs.kr","","https://github.com","","",""),
            CardDto(false,1,"1","최희건, CHOI HEE GUN","DGSW","","Android Developer","010-3159-4631","","","","https://github.com","","",""),
            CardDto(false,1,"1","최희건, CHOI HEE GUN","DGSW","","Android Developer","010-3159-4631","","","","https://github.com","","",""),
            CardDto(false,1,"1","최희건, CHOI HEE GUN","DGSW","","Android Developer","010-3159-4631","","","","https://github.com","","",""),

        )

        return list
    }

    override suspend fun getCardList(): List<CardDto>? {

//        val list = mutableListOf<CardDto>()
//
//        val imageList = cardApi.getCardList().data?.map { it.toDto() }
//        val templeteList = cardApi.getTempleteCardList().data?.map { it.toDto() }
//
//        if(imageList == null && templeteList == null){
//            return null
//        }
//
//        if(imageList != null){
//            list.addAll(imageList)
//        }
//
//        if(templeteList != null){
//            list.addAll(templeteList)
//        }
//
//        return list

        val list = listOf<CardDto>(
            CardDto(false,1,"1","최희건, CHOI HEE GUN","DGSW","","Android Developer","010-3159-4631","053-783-6664","nakim3159@gmail.com,nakim3159@dgsw.hs.kr","","https://github.com","","",""),
            CardDto(false,1,"1","최희건, CHOI HEE GUN","DGSW","","Android Developer","010-3159-4631","","","","https://github.com","","",""),
            CardDto(false,1,"1","최희건, CHOI HEE GUN","DGSW","","Android Developer","010-3159-4631","","","","https://github.com","","",""),
            CardDto(false,1,"1","최희건, CHOI HEE GUN","DGSW","","Android Developer","010-3159-4631","","","","https://github.com","","",""),

            )

        return list

    }

}