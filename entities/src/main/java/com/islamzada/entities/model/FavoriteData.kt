package com.islamzada.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class FavoriteData (
    var id: Int = 0,
    var name: String = "",
    var address: String = "",
    var city: String = "",
    var country: String = "",
    var thumbnailImage: String = "",
    var starRating: Double = 0.0,
    var reviewScore: Double = 0.0,
    var cityCenterPointDistanceName: String = "",
    var cityCenterPointDistance: Double = 0.0
) : Parcelable