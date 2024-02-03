package com.islamzada.entities.model

import com.google.gson.annotations.SerializedName


data class Type (

  @SerializedName("id"                 ) var id                 : String? = null,
  @SerializedName("name"               ) var name               : String? = null,
  @SerializedName("typeCode"           ) var typeCode           : String? = null,
  @SerializedName("characteristicCode" ) var characteristicCode : String? = null

)