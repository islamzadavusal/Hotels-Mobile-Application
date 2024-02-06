package com.islamzada.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class RoomClass (
  var code        : String?  = null,
  var description : String?  = null,
  var refundable  : Boolean? = null,
  var promotion   : Boolean? = null,
  var packageField : Boolean? = null,
  var offer       : Boolean? = null
) : Parcelable