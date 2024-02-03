package com.islamzada.entities.model

import com.google.gson.annotations.SerializedName


data class Concept (

  @SerializedName("code"                 ) var code                 : String? = null,
  @SerializedName("description"          ) var description          : String? = null,
  @SerializedName("parentCode"           ) var parentCode           : String? = null,
  @SerializedName("conceptIconColorCode" ) var conceptIconColorCode : String? = null,
  @SerializedName("conceptIcon"          ) var conceptIcon          : String? = null

)