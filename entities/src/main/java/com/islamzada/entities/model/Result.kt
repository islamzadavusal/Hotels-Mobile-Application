package com.islamzada.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result (

  var requestId      : String?                   = null,
  var funnelId       : String?                   = null,
  var offers         : Offers?                   = Offers(),
  var filters        : ArrayList<Filters>        = arrayListOf(),
  var sortingMethods : ArrayList<SortingMethods> = arrayListOf(),
  var searchUrl      : String?                   = null

) : Parcelable