package com.islamzada.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Filters (

  var min   : Min?              = Min(),
  var max   : Max?              = Max(),
  var title : String?           = null,
  var name  : String?           = null,
  var icon  : String?           = null,
  var type  : String?           = null,
  var items : ArrayList<Items> = arrayListOf()

) : Parcelable