package com.example.data.network.response

data class BaseResponse<T>(

    val code : Int,
    val message : String,
    val data : T?

)