package com.islamzada.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HotelsResponse (

  var responseCode    : Int?             = null,
  var errors          : String?          = null,
  var message         : String?          = null,
  var result          : Result?          = Result(),
  var campaignBanners : CampaignBanners? = CampaignBanners()

) : Parcelable