package com.example.data.network.request

import okhttp3.MultipartBody

data class PostCardRequest(
    val card_image : MultipartBody.Part
)
