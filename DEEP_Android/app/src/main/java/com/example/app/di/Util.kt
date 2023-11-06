package com.example.app.di

import javax.inject.Qualifier

val BASE_URL = "http://172.16.1.21:8080"

val BASE_CLOVA_URL = "https://c6tg0v6710.apigw.ntruss.com/custom/v1/25937/81530aafd2bfb4ccd47f3196ddc81d0a6794bc681d284f5936c8e5f790283ca1/document/"

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BasicRetrofit
