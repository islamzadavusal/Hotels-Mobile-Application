package com.islamzada.entities.model

import com.google.gson.annotations.SerializedName


data class Hotels (

  @SerializedName("id"      ) var id      : Int?             = null,
  @SerializedName("details" ) var details : Details?         = Details(),
  @SerializedName("rooms"   ) var rooms   : ArrayList<Rooms> = arrayListOf(),
  @SerializedName("cached"  ) var cached  : Boolean?         = null,
  @SerializedName("df"      ) var df      : Boolean?         = null,
  @SerializedName("fc"      ) var fc      : Boolean?         = null

)