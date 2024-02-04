package com.islamzada.entities.uimodel

data class HotelSearchUIState(
    val header: HotelSearchHeaderUIModel,
    val hotels: List<HotelUIModel>
)

data class HotelSearchHeaderUIModel(
    val requestId: String,
    val funnelId: String
)

data class HotelUIModel(
    val id: Int,
    val name: String,
    val address: String,
    val city: String,
    val country: String,
    val starRating: Double,
    val reviewScore: Double,
    val checkInTime: String,
    val checkOutTime: String,
    val cityCenterPointDistance: Double,
    val cityCenterPointDistanceName: String,
    val image: String,
    val thumbnailImage: String,
    val roomUIModels: List<RoomUIModel>
)

data class RoomUIModel(
    val reference: String,
    val roomType: String,
    val totalCount: Int,
    val availableCount: Int,
    val price: Int,
    val conceptDescription: String,
    val roomClassDescription: String,
    val imageUrl: String
)
