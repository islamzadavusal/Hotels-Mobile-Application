package com.islamzada.entities.model

import com.google.gson.annotations.SerializedName


data class Rooms (

  @SerializedName("reference"   ) var reference   : String?           = null,
  @SerializedName("type"        ) var type        : Type?             = Type(),
  @SerializedName("images"      ) var images      : ArrayList<Images> = arrayListOf(),
  @SerializedName("offers"      ) var offers      : ArrayList<Offers> = arrayListOf(),
  @SerializedName("facilities"  ) var facilities  : ArrayList<String> = arrayListOf(),
  @SerializedName("information" ) var information : ArrayList<String> = arrayListOf(),
  @SerializedName("alerts"      ) var alerts      : ArrayList<String> = arrayListOf(),
  @SerializedName("description" ) var description : String?           = null

)