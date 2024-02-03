package com.islamzada.entities.model

import com.google.gson.annotations.SerializedName


data class Policies (

  @SerializedName("checkin"              ) var checkin             : Checkin? = Checkin(),
  @SerializedName("checkout"             ) var checkout            : String?  = null,
  @SerializedName("instructions"         ) var instructions        : String?  = null,
  @SerializedName("special_instructions" ) var specialInstructions : String?  = null,
  @SerializedName("checkin_min_age"      ) var checkinMinAge       : String?  = null,
  @SerializedName("fees"                 ) var fees                : Fees?    = Fees(),
  @SerializedName("know_before_you_go"   ) var knowBeforeYouGo     : String?  = null

)