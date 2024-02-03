package com.islamzada.entities.model

import com.google.gson.annotations.SerializedName


data class Filters (

  @SerializedName("min"   ) var min   : Min?              = Min(),
  @SerializedName("max"   ) var max   : Max?              = Max(),
  @SerializedName("title" ) var title : String?           = null,
  @SerializedName("name"  ) var name  : String?           = null,
  @SerializedName("icon"  ) var icon  : String?           = null,
  @SerializedName("type"  ) var type  : String?           = null,
  @SerializedName("items" ) var items : ArrayList<String> = arrayListOf()

)