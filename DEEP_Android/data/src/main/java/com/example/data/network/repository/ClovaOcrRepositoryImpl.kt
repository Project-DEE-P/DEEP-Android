package com.example.data.network.repository

import android.util.Log
import com.example.data.network.api.ClovaOcrApi
import com.example.data.network.mapper.toDto
import com.example.data.network.mapper.toRequest
import com.example.domain.model.ClovaOcrDto
import com.example.domain.model.MessageModel
import com.example.domain.repository.ClovaOcrRepository
import okhttp3.MultipartBody
import javax.inject.Inject

class ClovaOcrRepositoryImpl @Inject constructor(
    private val clovaOcrApi: ClovaOcrApi
): ClovaOcrRepository {
    override suspend fun postClovaOcr(
        file: MultipartBody.Part,
        message: MessageModel
    ): ClovaOcrDto {
        return clovaOcrApi.postClovaOcr(message = message.toRequest(), file = listOf(file)).toDto()
    }

}