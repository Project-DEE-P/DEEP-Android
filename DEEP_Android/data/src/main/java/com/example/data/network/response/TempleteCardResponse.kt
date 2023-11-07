package com.example.data.network.response

data class TempleteCardResponse(

    val id: Long,
    val uid: String,
    val template: String,
    val name: String,
    val position: String,
    val department: String,
    val phone: String,
    val email: String,
    val github: String,
    val createdDateTime: String,
    val modifiedDateTime: String
)
