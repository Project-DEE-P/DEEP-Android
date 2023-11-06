package com.example.app.di.module

import com.example.app.di.BASE_CLOVA_URL
import com.example.app.di.BASE_URL
import com.example.data.network.api.CardApi
import com.example.data.network.api.ClovaOcrApi
import com.example.data.remote.api.UserApi
import com.ggd.qualifier.BasicRetrofit
import com.ggd.qualifier.ClovaRetrofit
import com.ggd.qualifier.HeaderInterceptor
import com.ggd.qualifier.LoggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    /* LoginApi Type의 객체 생성 */

    @Provides
    @Singleton
    fun provideCardApi(@BasicRetrofit retrofit: Retrofit): CardApi =
        retrofit.create(CardApi::class.java)

    @Provides
    @Singleton
    fun provideUserApi(@BasicRetrofit retrofit: Retrofit): UserApi =
        retrofit.create(UserApi::class.java)

    @Provides
    @Singleton
    fun provideClovaApi(@ClovaRetrofit retrofit: Retrofit): ClovaOcrApi =
        retrofit.create(ClovaOcrApi::class.java)

    /* Retrofit Object 생성 */

    @BasicRetrofit
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @ClovaRetrofit
    @Provides
    @Singleton
    fun provideClovaRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_CLOVA_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /* OkHttp로 세부적인 네트워크 구성요소를 설정 */

    @Singleton
    @Provides
    fun provideOkHttpClient(
        @HeaderInterceptor headerInterceptor: Interceptor,
    ): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient().newBuilder()
        okHttpClientBuilder.connectTimeout(60, TimeUnit.SECONDS)
        okHttpClientBuilder.readTimeout(60, TimeUnit.SECONDS)
        okHttpClientBuilder.writeTimeout(60, TimeUnit.SECONDS)
        okHttpClientBuilder.addInterceptor(headerInterceptor)

        return okHttpClientBuilder.build()
    }

//    @Singleton
//    @Provides
//    fun provideOkHttpNoHeaderClient(
//        @LoggingInterceptor loggerInterceptor: Interceptor,
//    ): OkHttpClient {
//        val okHttpClientBuilder = OkHttpClient().newBuilder()
//        okHttpClientBuilder.connectTimeout(60, TimeUnit.SECONDS)
//        okHttpClientBuilder.readTimeout(60, TimeUnit.SECONDS)
//        okHttpClientBuilder.writeTimeout(60, TimeUnit.SECONDS)
//        okHttpClientBuilder.addInterceptor(loggerInterceptor)
//
//        return okHttpClientBuilder.build()
//    }

//
//    @Provides
//    @Singleton
//    @LoggingInterceptor
//    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
//        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }

    @Provides
    @Singleton
    @HeaderInterceptor
    fun provideHeaderInterceptor() = Interceptor { chain ->
        with(chain) {
            val newRequest = request().newBuilder()
                .addHeader("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiIxIiwiaWF0IjoxNjk2NTY1MDE5LCJleHAiOjE2OTcxNjk4MTksImlzcyI6IkRFRVAiLCJzdWIiOiJ0b2tlbiJ9.eMqrjy-pdqXd3WZ8QowB7AXsL-2ZNL0xhktZNtsXFIk")
                .build()
            proceed(newRequest)
       }
    }
}