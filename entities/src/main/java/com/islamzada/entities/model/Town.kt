package com.islamzada.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Town (

  var id   : String? = null,
  var name : String? = null

) : Parcelable