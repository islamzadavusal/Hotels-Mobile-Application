package com.islamzada.entities.model

import com.google.gson.annotations.SerializedName


data class Domestic (

  @SerializedName("image" ) var image : String? = null,
  @SerializedName("index" ) var index : Int?    = null

)