package com.example.app.di.module

import com.example.data.network.api.CardApi
import com.example.data.remote.api.UserApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
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

    @Provides
    @Singleton
    fun provideUserApi(retrofit: Retrofit): UserApi =
        retrofit.create(UserApi::class.java)

    /* Retrofit Object 생성 */

//    @Provides
//    @Singleton
//    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
//        return Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .client(okHttpClient)
//            .build()
//    }

    /* OkHttp로 세부적인 네트워크 구성요소를 설정 */

//    @Singleton
//    @Provides
//    fun provideOkHttpClient(
//        @HeaderInterceptor headerInterceptor: Interceptor,
//        @LoggingInterceptor LoggerInterceptor: HttpLoggingInterceptor,
//    ): OkHttpClient {
//        val okHttpClientBuilder = OkHttpClient().newBuilder()
//        okHttpClientBuilder.connectTimeout(60, TimeUnit.SECONDS)
//        okHttpClientBuilder.readTimeout(60, TimeUnit.SECONDS)
//        okHttpClientBuilder.writeTimeout(60, TimeUnit.SECONDS)
//        okHttpClientBuilder.addInterceptor(LoggerInterceptor)
//        okHttpClientBuilder.addInterceptor(headerInterceptor)
//
//        return okHttpClientBuilder.build()
//    }

//    @Provides
//    @Singleton
//    @LoggingInterceptor
//    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
//        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
//
//    @Provides
//    @Singleton
//    @HeaderInterceptor
//    fun provideHeaderInterceptor() = Interceptor { chain ->
//        with(chain) {
//            val newRequest = request().newBuilder()
//                .addHeader("AccessToken", HiltApplication.prefs.accessToken)
//                .build()
//            proceed(newRequest)
//       }
//    }
}