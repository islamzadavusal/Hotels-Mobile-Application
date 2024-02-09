package com.islamzada.domain.mapper

import com.islamzada.entities.model.Result
import com.islamzada.entities.uimodel.HotelSearchHeaderUIModel
import com.islamzada.entities.uimodel.HotelSearchUIState
import com.islamzada.entities.uimodel.HotelUIModel
import javax.inject.Inject

//class HotelResponseToUIStateMapper @Inject constructor() : BaseMapper<HotelsResponse, HotelSearchUIState> {
//    override fun map(input: HotelsResponse): HotelSearchUIState {
//        return HotelSearchUIState(
//            header = input.result?.run {
//                HotelSearchHeaderUIModel(requestId ?: "defaultRequestId", funnelId ?: "defaultFunnelId")
//            } ?: HotelSearchHeaderUIModel("defaultRequestId", "defaultFunnelId"),
//            hotels = input.result?.offers?.hotels?.map {
//                mapHotel(it)
//            } ?: emptyList()
//        )
//    }
//
//
//    private fun mapHotel(hotel: Hotels): HotelUIModel {
//        return HotelUIModel(
//            id = hotel.id!!,
//            name = hotel.details!!.name ?: "",
//            address = hotel.details!!.address?.address ?: "",
//            city = hotel.details!!.address?.town?.name ?: "",
//            country = hotel.details!!.address?.country?.name ?: "",
//            starRating = hotel.details!!.starRating?.toDouble() ?: 0.0,
//            reviewScore = hotel.details!!.reviewScore?.toDouble() ?: 0.0,
//            checkInTime = hotel.details!!.checkInTime ?: "",
//            checkOutTime = hotel.details!!.checkOutTime ?: "",
//            cityCenterPointDistance = hotel.details!!.cityCenterPointDistance ?: 0.0,
//            cityCenterPointDistanceName = hotel.details!!.cityCenterPointDistanceName ?: "",
//            thumbnailImage = hotel.details!!.extra?.thumbnailImage ?: "",
//            roomUIModels = hotel.rooms.map {
//                mapRoom(it)
//            },
//            cached = hotel.cached!!,
//            df = hotel.df!!,
//            fc = hotel.fc!!
//        )
//    }
//
//    private fun mapRoom(room: Rooms): RoomUIModel {
//        return RoomUIModel(
//            reference = room.reference ?: "",
//            roomType = room.type?.name ?: "",
//            totalCount = room.offers.firstOrNull()?.totalCount ?: 0,
//            availableCount = room.offers.firstOrNull()?.availableCount ?: 0,
//            price = room.offers.firstOrNull()?.price ?: 0,
//            conceptDescription = room.offers.firstOrNull()?.concept?.description ?: "",
//            roomClassDescription = room.offers.firstOrNull()?.roomClass?.description ?: "",
//            imageUrl = room.images.firstOrNull()?.toString() ?: ""
//        )
//    }
//}

class HotelResponseToUIStateMapper @Inject constructor() : BaseMapper<Result, HotelSearchUIState> {
    override fun map(input: Result): HotelSearchUIState {
        return HotelSearchUIState(
            header = input.getSearchHeader(),
            hotels = input.getHotels()
        )
    }

    private fun Result.getSearchHeader(): HotelSearchHeaderUIModel {
        return HotelSearchHeaderUIModel(
            requestId = requestId ?: "",
            funnelId = funnelId ?: ""
        )
    }

    private fun Result.getHotels(): List<HotelUIModel> {
        return offers?.hotels?.map { hotel ->
            HotelUIModel(
                id = hotel.id ?: 0,
                name = hotel.details?.name ?: "",
                address = hotel.details?.address?.address ?: "",
                city = hotel.details?.address?.city?.name ?: "",
                country = hotel.details?.address?.country?.name ?: "",
                starRating = hotel.details?.starRating?.toDouble() ?: 0.0,
                reviewScore = hotel.details?.reviewScore?.toDouble() ?: 0.0,
                cityCenterPointDistance = hotel.details?.cityCenterPointDistance ?: 0.0,
                cityCenterPointDistanceName = hotel.details?.cityCenterPointDistanceName ?: "",
                image = hotel.details?.images?.firstOrNull()?.toString() ?: "",
                thumbnailImage = hotel.details?.extra?.thumbnailImage?: "",
                price = hotel.rooms?.firstOrNull()?.offers?.firstOrNull()?.price ?: 0

//
//                roomUIModels = hotel.rooms.map { room ->
//                    RoomUIModel(
//                        reference = room.reference ?: "",
//                        roomType = room.type?.name ?: "",
//                        totalCount = room.offers.firstOrNull()?.totalCount ?: 0,
//                        availableCount = room.offers.firstOrNull()?.availableCount ?: 0,
//                        price = room.offers.firstOrNull()?.price ?: 0,
//                        conceptDescription = room.offers.firstOrNull()?.concept?.description ?: "",
//                        roomClassDescription = room.offers.firstOrNull()?.roomClass?.description ?: "",
//                        imageUrl = room.images.firstOrNull()?.url ?: ""
//                    )
            //    }

            )
        } ?: listOf()
    }
}
