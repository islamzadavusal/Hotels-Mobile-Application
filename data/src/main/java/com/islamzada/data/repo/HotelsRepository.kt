package com.islamzada.data.repo

import com.islamzada.entities.model.HotelsResponse
import com.islamzada.network.api.ApiService
import javax.inject.Inject

interface HotelsRepositoryInterface {
    suspend fun getHotel() : HotelsResponse?
}

class HotelsRepository @Inject constructor(private val apiService : ApiService) : HotelsRepositoryInterface {
    override suspend fun getHotel(): HotelsResponse? {
        return apiService.getHotel()
    }
}