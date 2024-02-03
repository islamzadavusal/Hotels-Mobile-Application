package com.islamzada.entities.model

import com.google.gson.annotations.SerializedName


data class SortingMethods (

  @SerializedName("value"       ) var value       : Int?     = null,
  @SerializedName("text"        ) var text        : String?  = null,
  @SerializedName("default"     ) var default     : Boolean? = null,
  @SerializedName("description" ) var description : String?  = null

)