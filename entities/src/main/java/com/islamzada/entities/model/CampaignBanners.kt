package com.islamzada.entities.model

import com.google.gson.annotations.SerializedName


data class CampaignBanners (

  @SerializedName("domestic"      ) var domestic      : ArrayList<Domestic> = arrayListOf(),
  @SerializedName("international" ) var international : ArrayList<String>   = arrayListOf()

)