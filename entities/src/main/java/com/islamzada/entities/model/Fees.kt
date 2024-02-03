package com.islamzada.entities.model

import com.google.gson.annotations.SerializedName


data class Fees (

  @SerializedName("mandatory" ) var mandatory : String? = null,
  @SerializedName("optional"  ) var optional  : String? = null

)