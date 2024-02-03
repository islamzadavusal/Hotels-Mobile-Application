package com.islamzada.entities.model

import com.google.gson.annotations.SerializedName


data class Images (

  @SerializedName("url"  ) var url  : String? = null,
  @SerializedName("name" ) var name : String? = null,
  @SerializedName("type" ) var type : String? = null

)