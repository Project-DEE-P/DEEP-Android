package com.example.data.network.request

data class Message(
    val version : String = "V2",
    val requestId : String = "deep-card-ocr",
    val timestamp : Long,
    val images : List<Image>
)

data class Image(
    val format : String,
    val name : String
)