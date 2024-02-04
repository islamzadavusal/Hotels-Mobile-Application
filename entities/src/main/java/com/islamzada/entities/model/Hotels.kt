package com.islamzada.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hotels (

  var id      : Int?             = null,
  var details : Details?         = Details(),
  var rooms   : ArrayList<Rooms> = arrayListOf(),
  var cached  : Boolean?         = null,
  var df      : Boolean?         = null,
  var fc      : Boolean?         = null

) : Parcelable