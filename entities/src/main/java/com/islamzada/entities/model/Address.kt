package com.islamzada.entities.model

import com.google.gson.annotations.SerializedName


data class Address (

  @SerializedName("address"     ) var address     : String?  = null,
  @SerializedName("zipCode"     ) var zipCode     : String?  = null,
  @SerializedName("country"     ) var country     : Country? = Country(),
  @SerializedName("countryCode" ) var countryCode : String?  = null,
  @SerializedName("town"        ) var town        : Town?    = Town(),
  @SerializedName("city"        ) var city        : City?    = City()

)