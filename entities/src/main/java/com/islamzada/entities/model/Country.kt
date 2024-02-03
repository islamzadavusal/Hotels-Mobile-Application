package com.islamzada.entities.model

import com.google.gson.annotations.SerializedName


data class Country (

  @SerializedName("code" ) var code : String? = null,
  @SerializedName("name" ) var name : String? = null

)