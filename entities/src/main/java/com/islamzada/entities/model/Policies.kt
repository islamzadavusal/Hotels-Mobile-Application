package com.islamzada.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Policies (
  var checkin             : CheckIn? = CheckIn(),
  var checkout            : String?  = null,
  var instructions        : String?  = null,
  var specialInstructions : String?  = null,
  var checkInMinAge       : String?  = null,
  var fees                : Fees?    = Fees(),
  var knowBeforeYouGo     : String?  = null
) : Parcelable