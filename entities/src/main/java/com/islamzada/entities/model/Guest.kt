package com.islamzada.entities.model

import com.google.gson.annotations.SerializedName


data class Guest (

  @SerializedName("adults"   ) var adults   : Int? = null,
  @SerializedName("children" ) var children : Int? = null

)