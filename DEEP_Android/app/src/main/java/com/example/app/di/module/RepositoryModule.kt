package com.example.app.di.module

import com.example.data.network.repository.CardRepositoryImpl
import com.example.data.network.repository.ClovaOcrRepositoryImpl
import com.example.data.repository.UserRepositoryImpl
import com.example.domain.repository.CardRepository
import com.example.domain.repository.ClovaOcrRepository
import com.example.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideLoginRepository(
        impl : CardRepositoryImpl
    ): CardRepository = impl


    @Provides
    @Singleton
    fun provideUserRepository(
        impl : UserRepositoryImpl
    ): UserRepository = impl

    @Provides
    @Singleton
    fun provideClovaOcrRepository(
        impl : ClovaOcrRepositoryImpl
    ) : ClovaOcrRepository = impl

}
