package com.example.domain.repository

import com.example.domain.model.ClovaOcrDto
import com.example.domain.model.MessageModel
import okhttp3.MultipartBody

interface ClovaOcrRepository {

    suspend fun postClovaOcr(
        file : MultipartBody.Part,
        message : MessageModel
    ) : ClovaOcrDto

}