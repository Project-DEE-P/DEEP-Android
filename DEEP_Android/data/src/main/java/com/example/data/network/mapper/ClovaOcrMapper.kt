package com.example.data.network.mapper

import com.example.data.network.request.Image
import com.example.data.network.request.Message
import com.example.data.network.response.BoundingPoly
import com.example.data.network.response.ClovaOcrResponse
import com.example.data.network.response.Meta
import com.example.data.network.response.Name
import com.example.data.network.response.NameCard
import com.example.data.network.response.Result
import com.example.data.network.response.ValidationResult
import com.example.data.network.response.Vertice
import com.example.domain.model.BoundingPolyDto
import com.example.domain.model.ClovaOcrDto
import com.example.domain.model.ImageDto
import com.example.domain.model.ImageModel
import com.example.domain.model.MessageModel
import com.example.domain.model.MetaDto
import com.example.domain.model.NameCardDto
import com.example.domain.model.NameDto
import com.example.domain.model.ResultDto
import com.example.domain.model.ValidationResultDto
import com.example.domain.model.VerticeDto

fun MessageModel.toRequest() = Message(
    version = this.version,
    requestId = this.requestId,
    timestamp = this.timestamp,
    images = this.images.map { it.toRequest() }
)

fun ImageModel.toRequest() = Image(
    format = this.format,
    name = this.name
)


fun ClovaOcrResponse.toDto() = ClovaOcrDto(
    version = this.version,
    requestId = this.requestId,
    timestamp = this.timestamp,
    images = this.images.map{it.toDto()}
)

fun com.example.data.network.response.Image.toDto() = ImageDto(
    nameCard = this.nameCard.toDto(),
    uid = this.uid,
    name = this.name,
    inferResult = this.inferResult,
    message = this.message,
    validationResult = this.validationResult?.toDto()
)

fun ValidationResult.toDto() = ValidationResultDto(
    result = this.result
)

fun NameCard.toDto() = NameCardDto(
    meta = this.meta?.toDto(),
    result = this.result.toDto()
)

fun Meta.toDto() = MetaDto(
    estimatedLanguage = this.estimatedLanguage
)

fun Result.toDto() = ResultDto(
    name = this.name?.map{it.toDto()},
    company = this.company?.map{it.toDto()},
    address = this.address?.map{it.toDto()},
    position = this.position?.map{it.toDto()},
    mobile = this.mobile?.map{it.toDto()},
    tel = this.tel?.map{it.toDto()},
    email = this.email?.map{it.toDto()},
    fax = this.fax?.map{it.toDto()},
    homepage = this.homepage?.map{it.toDto()},
    nameFurigana = this.nameFurigana?.map{it.toDto()},
    department = this.department?.map{it.toDto()}
)

fun Name.toDto() = NameDto(
    text = this.text,
    boundingPolys = this.boundingPolys?.map { it.toDto() },
    maskingPolys = this.maskingPolys
)

fun BoundingPoly.toDto() = BoundingPolyDto(
    vertices = this.vertices?.map { it.toDto() }
)

fun Vertice.toDto() = VerticeDto(
    x = this.x,
    y = this.y
)




































