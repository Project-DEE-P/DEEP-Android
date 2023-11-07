package com.example.app.presentation.screen.putnfc

data class OcrResultData(
    val type : OcrType,
    val value : String,
    val isAddress : Boolean,
    val isCopy : Boolean,
    val isLink : Boolean
)

enum class OcrType(
){
    회사,
    직책,
    부서,
    주소,
    모바일,
    전화,
    팩스,
    홈페이지,
    이메일


}