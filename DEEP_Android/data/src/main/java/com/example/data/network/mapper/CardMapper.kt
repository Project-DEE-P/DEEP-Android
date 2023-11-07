package com.example.data.network.mapper

import com.example.data.network.request.PostCardRequest
import com.example.data.network.response.CardResponse
import com.example.data.network.response.TempleteCardResponse
import com.example.domain.model.card.CardDto
import com.example.domain.model.card.PostCardModel

fun PostCardModel.toRequest() : PostCardRequest = PostCardRequest(

    name = this.name,
    company = this.company,
    address = this.address,
    position = this.position,
    mobile = this.mobile,
    tel = this.tel,
    email = this.email,
    fax = this.fax,
    homepage = this.homepage,
    department = this.department
)

fun CardResponse.toDto() : CardDto = CardDto(

    isTemplete = false,
    id = this.id,
    uid = this.uid,
    name = this.name,
    company = this.company,
    address = this.address,
    position = this.position,
    mobile = this.mobile,
    tel = this.tel,
    email = this.email,
    fax = this.fax,
    homepage = this.homepage,
    department = this.department,
    createdDateTime = this.createdDateTime,
    modifiedDateTime = this.modifiedDateTime
)

fun TempleteCardResponse.toDto() : CardDto = CardDto(

    isTemplete = true,
    id = this.id,
    uid = this.uid,
    name = this.name,
    company = "",
    address = "",
    position = this.position,
    mobile = this.phone,
    tel = "",
    email = this.email,
    fax = "",
    homepage = this.github,
    department = this.department,
    createdDateTime = this.createdDateTime,
    modifiedDateTime = this.modifiedDateTime
)

