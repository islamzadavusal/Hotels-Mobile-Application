package com.islamzada.network.api

import com.islamzada.entities.model.HotelsResponse
import retrofit2.http.GET

interface ApiService {
    @GET("hotels")
    suspend fun getHotel(): HotelsResponse?
}