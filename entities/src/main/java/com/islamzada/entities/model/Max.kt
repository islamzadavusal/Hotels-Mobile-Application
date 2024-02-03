package com.islamzada.entities.model

import com.google.gson.annotations.SerializedName


data class Max (

  @SerializedName("name"     ) var name     : String? = null,
  @SerializedName("code"     ) var code     : String? = null,
  @SerializedName("value"    ) var value    : String? = null,
  @SerializedName("type"     ) var type     : String? = null,
  @SerializedName("position" ) var position : Int?    = null,
  @SerializedName("count"    ) var count    : String? = null

)