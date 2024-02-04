package com.islamzada.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Rooms (

  var reference   : String?           = null,
  var type        : Type?             = Type(),
  var images      : ArrayList<Images> = arrayListOf(),
  var offers      : ArrayList<Offers> = arrayListOf(),
  var facilities  : ArrayList<String> = arrayListOf(),
  var information : ArrayList<String> = arrayListOf(),
  var alerts      : ArrayList<String> = arrayListOf(),
  var description : String?           = null

) : Parcelable