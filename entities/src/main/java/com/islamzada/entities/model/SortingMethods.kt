package com.islamzada.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SortingMethods (

  var value       : Int?     = null,
  var text        : String?  = null,
  var default     : Boolean? = null,
  var description : String?  = null

) : Parcelable