package com.islamzada.entities.model

import com.google.gson.annotations.SerializedName


data class Offers (

  @SerializedName("hotels"         ) var hotels         : ArrayList<Hotels> = arrayListOf(),
  @SerializedName("totalCount"     ) var totalCount     : Int?              = null,
  @SerializedName("availableCount" ) var availableCount : Int?              = null,
  @SerializedName("price"          ) var price          : Int?              = null,
  @SerializedName("concept"        ) var concept        : Concept?          = null,
  @SerializedName("roomClass"      ) var roomClass      : RoomClass?        = null

)