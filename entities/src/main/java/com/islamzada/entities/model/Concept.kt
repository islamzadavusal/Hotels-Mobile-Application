package com.islamzada.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Concept (

  var code                 : String? = null,
  var description          : String? = null,
  var parentCode           : String? = null,
  var conceptIconColorCode : String? = null,
  var conceptIcon          : String? = null

) : Parcelable