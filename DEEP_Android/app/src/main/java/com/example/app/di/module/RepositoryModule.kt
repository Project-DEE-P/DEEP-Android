package com.example.app.di.module

import com.example.data.network.repository.CardRepositoryImpl
import com.example.domain.repository.CardRepository
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


}
