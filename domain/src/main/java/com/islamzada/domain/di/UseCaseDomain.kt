package com.islamzada.domain.di

import com.islamzada.data.repo.FavoriteRepositoryInterface
import com.islamzada.data.repo.HotelsRepositoryInterface
import com.islamzada.domain.usecase.FavoriteHotelUseCase
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
    fun provideHotelsUseCase(repositoryHotelInterface: HotelsRepositoryInterface) = MainHotelsUseCase(repositoryHotelInterface)

    @Provides
    @Singleton
    fun provideFavoriteUseCase(repositoryFavInterface: FavoriteRepositoryInterface) = FavoriteHotelUseCase(repositoryFavInterface)
}