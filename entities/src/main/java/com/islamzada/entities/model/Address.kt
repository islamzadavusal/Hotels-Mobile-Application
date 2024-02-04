package com.islamzada.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Address (

  var address     : String?  = null,
  var zipCode     : String?  = null,
  var country     : Country? = Country(),
  var countryCode : String?  = null,
  var town        : Town?    = Town(),
  var city        : City?    = City()

) : Parcelable