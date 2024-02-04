package com.islamzada.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class CheckIn (

  var beginTime : String? = null,
  var endTime   : String? = null

) : Parcelable