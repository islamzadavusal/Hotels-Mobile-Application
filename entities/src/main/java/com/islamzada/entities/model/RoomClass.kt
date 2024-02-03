package com.islamzada.entities.model

import com.google.gson.annotations.SerializedName


data class RoomClass (

  @SerializedName("code"        ) var code        : String?  = null,
  @SerializedName("description" ) var description : String?  = null,
  @SerializedName("refundable"  ) var refundable  : Boolean? = null,
  @SerializedName("promotion"   ) var promotion   : Boolean? = null,
  @SerializedName("package"     ) var packageName : Boolean? = null,
  @SerializedName("offer"       ) var offer       : Boolean? = null

)