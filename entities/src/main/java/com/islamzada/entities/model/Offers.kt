package com.islamzada.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Offers (
  var hotels         : ArrayList<Hotels> = arrayListOf(),
  var totalCount     : Int?              = null,
  var availableCount : Int?              = null,
  var price          : Int?              = null,
  var concept        : Concept?          = null,
  var roomClass      : RoomClass?        = null
) : Parcelable