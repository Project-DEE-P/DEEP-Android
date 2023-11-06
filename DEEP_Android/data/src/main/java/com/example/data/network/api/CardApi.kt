package com.example.data.network.api

import com.example.data.network.request.PostCardRequest
import com.example.data.network.response.BaseResponse
import com.example.data.network.response.CardResponse
import com.example.data.network.response.RememberCardResponse
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query

interface CardApi {

    @Multipart
    @POST("/v1/api/card")
    suspend fun postCard(
        @Part card_image : MultipartBody.Part
    ) : BaseResponse<Any>

    @POST("v1/api/card/{id}/remember")
    suspend fun rememberCard(
        @Path("id") id : Int
    ) : BaseResponse<Any>

    @GET("v1/api/card/remember")
    suspend fun getRememberedCardList(

    ) : BaseResponse<List<RememberCardResponse>>

    @GET("v1/api/card/{id}")
    suspend fun getCard(
        @Path("id") id : Int
    ) : BaseResponse<CardResponse>

    @GET("v1/api/card")
    suspend fun getCardList(

    ) : BaseResponse<List<CardResponse>>

    @DELETE("v1/api/card/{id}")
    suspend fun deleteCardList(
        @Path("id") id : Int
    ) : BaseResponse<Any>
}