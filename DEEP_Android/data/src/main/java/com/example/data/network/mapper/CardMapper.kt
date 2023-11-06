package com.example.data.network.mapper

import com.example.data.network.response.CardResponse
import com.example.data.network.response.RememberCardResponse
import com.example.domain.model.CardModel

fun CardResponse.toModel() : CardModel = CardModel(

    id = this.id,
    uid = this.uid,
    createdDateTime = this.createdDateTime,
    modifiedDateTime = this.modifiedDateTime,
    imagePath = this.imagePath

)

fun RememberCardResponse.toModel() : CardModel = CardModel(

    id = this.id,
    uid = this.uid,
    createdDateTime = this.card.createdDateTime,
    modifiedDateTime = this.card.modifiedDateTime,
    imagePath = this.card.imagePath

)