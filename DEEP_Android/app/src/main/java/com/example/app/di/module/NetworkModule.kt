package com.example.app.di.module

import com.example.app.di.BASE_URL
import com.example.data.network.api.CardApi
import com.ggd.qualifier.HeaderInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
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
    fun provideCardApi(retrofit: Retrofit): CardApi =
        retrofit.create(CardApi::class.java)

    /* Retrofit Object 생성 */

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
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
                .addHeader("Authorization","Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiJhZG1pbiIsImlhdCI6MTY5NjUxNTY1OSwiZXhwIjoxNjk3MTIwNDU5LCJpc3MiOiJERUVQIiwic3ViIjoidG9rZW4ifQ.Bl7vjv_hPUpzsl0q5BUotgYR4MSHMF4InHOs2Y6JHsw")
                .build()
            proceed(newRequest)
       }
    }
}