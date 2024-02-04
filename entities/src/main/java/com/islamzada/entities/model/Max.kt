package com.islamzada.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Max (

  var name     : String? = null,
  var code     : String? = null,
  var value    : String? = null,
  var type     : String? = null,
  var position : Int?    = null,
  var count    : String? = null

) : Parcelable