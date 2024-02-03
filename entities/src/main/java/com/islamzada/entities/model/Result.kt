package com.islamzada.entities.model

import com.google.gson.annotations.SerializedName


data class Result (

  @SerializedName("requestId"      ) var requestId      : String?                   = null,
  @SerializedName("funnelId"       ) var funnelId       : String?                   = null,
  @SerializedName("offers"         ) var offers         : Offers?                   = Offers(),
  @SerializedName("filters"        ) var filters        : ArrayList<Filters>        = arrayListOf(),
  @SerializedName("sortingMethods" ) var sortingMethods : ArrayList<SortingMethods> = arrayListOf(),
  @SerializedName("searchUrl"      ) var searchUrl      : String?                   = null

)