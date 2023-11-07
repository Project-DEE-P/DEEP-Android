package com.example.app.presentation.screen.create

import android.media.Image
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.*
import androidx.lifecycle.viewModelScope
import com.example.app.util.TAG
import com.example.data.network.request.Message
import com.example.domain.model.ClovaOcrDto
import com.example.domain.model.ImageDto
import com.example.domain.model.MessageModel
import com.example.domain.model.MetaDto
import com.example.domain.model.NameCardDto
import com.example.domain.model.NameDto
import com.example.domain.model.ResultDto
import com.example.domain.model.ValidationResultDto
import com.example.domain.model.card.PostCardModel
import com.example.domain.repository.CardRepository
import com.example.domain.repository.ClovaOcrRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor(
    private val cardRepository: CardRepository,
    private val clovaOcrRepository: ClovaOcrRepository

): ViewModel() {


    val data = ClovaOcrDto(
        images = listOf(
            ImageDto(
                nameCard = NameCardDto(
                    meta = MetaDto(
                        ""
                    ),
                    result = ResultDto(
                        name = listOf(
                            NameDto(
                                boundingPolys = listOf(),
                                maskingPolys = listOf(),
                                text = "최희건"
                            ),
                            NameDto(
                                boundingPolys = listOf(),
                                maskingPolys = listOf(),
                                text = "Choi Heegun"
                            ),
                        ),
                        company = listOf(
                            NameDto(
                                boundingPolys = listOf(),
                                maskingPolys = listOf(),
                                text = "(주)우아한 형제들"
                            )
                        ),
                        address = null,
                        position = null,
                        mobile = null,
                        tel = listOf(
                            NameDto(
                                boundingPolys = listOf(),
                                maskingPolys = listOf(),
                                text = "010-3159-4631"
                            ),
                            NameDto(
                                boundingPolys = listOf(),
                                maskingPolys = listOf(),
                                text = "010-9443-2321"
                            ),
                        ),
                        email = listOf(
                            NameDto(
                                boundingPolys = listOf(),
                                maskingPolys = listOf(),
                                text = "nakim3159@gmail.com"
                            )
                        ),
                        fax = null,
                        homepage = listOf(
                            NameDto(
                                boundingPolys = listOf(),
                                maskingPolys = listOf(),
                                text = "https://developer.android.com/guide/topics/text/copy-paste?hl=ko"
                            )
                        ),
                        nameFurigana = null,
                        department = listOf(
                            NameDto(
                                boundingPolys = listOf(),
                                maskingPolys = listOf(),
                                text = "홍보부"
                            )
                        ),
                    )
                ),
                inferResult = "",
                uid = "",
                name = "",
                message = "",
                validationResult = ValidationResultDto("")

            )
        ),
        requestId = "",
        timestamp = 1,
        version = ""
    )

    var isSuccess by mutableStateOf<Boolean?>(null)

    var dialogState by mutableStateOf<Boolean>(false)

    var clovaOcrResult by mutableStateOf<ClovaOcrDto?>(null)

    var requestData by mutableStateOf<PostCardModel?>(null)
    fun postCard(image : MultipartBody.Part, request : PostCardModel) = viewModelScope.launch(Dispatchers.IO) {
        kotlin.runCatching {
            cardRepository.postCard(image, request)
        }.onSuccess {
            Log.d(TAG,"CreateViewModel - Success")
            isSuccess = true
        }.onFailure {
            Log.d(TAG,"CreateViewModel - error - $it")
            isSuccess = false
        }
    }

    fun postClovaOcr(
        file : MultipartBody.Part,
        message: MessageModel
    ) = viewModelScope.launch(Dispatchers.IO) {

//        clovaOcrResult = data

        kotlin.runCatching {
            clovaOcrRepository.postClovaOcr(file, message)
        }.onSuccess {
            clovaOcrResult = it
        }.onFailure {
            Log.d(TAG,"postClovaOcr - error - $it")
        }
    }

}