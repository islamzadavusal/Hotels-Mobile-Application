package com.islamzada.data.di

import com.islamzada.data.repo.HotelsRepository
import com.islamzada.data.repo.HotelsRepositoryInterface
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun providerHotelsRepository(repository: HotelsRepository) : HotelsRepositoryInterface
}