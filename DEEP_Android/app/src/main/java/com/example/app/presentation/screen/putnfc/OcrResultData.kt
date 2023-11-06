package com.example.app.presentation.screen.putnfc

data class OcrResultData(
    val items : Item
)

data class Item(
    val name : String,
    val datas : List<Data>
)

data class Data(
    val value : String,
    val isAddress : Boolean,
    val isCopy : Boolean,
    val isLink : Boolean
)
