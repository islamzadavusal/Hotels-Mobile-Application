package com.islamzada.domain.di

import com.islamzada.data.repo.HotelsRepositoryInterface
import com.islamzada.domain.usecase.MainHotelsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseDomain {

    @Provides
    @Singleton
    fun provideHotelsUseCase(repositoryInterface: HotelsRepositoryInterface) = MainHotelsUseCase(repositoryInterface)
}