package com.example.data.network.api

import com.example.data.network.request.Message
import com.example.data.network.response.BaseResponse
import com.example.data.network.response.ClovaOcrResponse
import okhttp3.MultipartBody
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ClovaOcrApi {

    @Multipart
    @POST("name-card")
    suspend fun postClovaOcr(
        @Header("X-OCR-SECRET") secret : String = "Rk1KWnVyUnlRcEZzdUJEbkVBeU9vTU9QcG1pRlhOQWk=",
//        @Header("Content-Type") contentType : String = "multipart/form-data",
        @Part("message") message : Message,
        @Part file : List<MultipartBody.Part>
    ) : ClovaOcrResponse

}






