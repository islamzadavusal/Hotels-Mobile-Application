package com.islamzada.entities.model

import com.google.gson.annotations.SerializedName


data class Details (

  @SerializedName("id"                          ) var id                          : String?           = null,
  @SerializedName("slug"                        ) var slug                        : String?           = null,
  @SerializedName("address"                     ) var address                     : Address?          = Address(),
  @SerializedName("coordinate"                  ) var coordinate                  : Coordinate?       = Coordinate(),
  @SerializedName("description"                 ) var description                 : String?           = null,
  @SerializedName("hotelInfoDescription"        ) var hotelInfoDescription        : String?           = null,
  @SerializedName("facilitiesGroup"             ) var facilitiesGroup             : ArrayList<String> = arrayListOf(),
  @SerializedName("suitabilities"               ) var suitabilities               : ArrayList<String> = arrayListOf(),
  @SerializedName("hotelDescriptions"           ) var hotelDescriptions           : ArrayList<String> = arrayListOf(),
  @SerializedName("extra"                       ) var extra                       : Extra?            = Extra(),
  @SerializedName("name"                        ) var name                        : String?           = null,
  @SerializedName("images"                      ) var images                      : ArrayList<String> = arrayListOf(),
  @SerializedName("starRating"                  ) var starRating                  : Int?              = null,
  @SerializedName("reviewScore"                 ) var reviewScore                 : Int?              = null,
  @SerializedName("reviews"                     ) var reviews                     : String?           = null,
  @SerializedName("reviewInfo"                  ) var reviewInfo                  : String?           = null,
  @SerializedName("reviewScoreLocalized"        ) var reviewScoreLocalized        : String?           = null,
  @SerializedName("generalReviewScoreNote"      ) var generalReviewScoreNote      : String?           = null,
  @SerializedName("checkInTime"                 ) var checkInTime                 : String?           = null,
  @SerializedName("checkOutTime"                ) var checkOutTime                : String?           = null,
  @SerializedName("domestic"                    ) var domestic                    : Boolean?          = null,
  @SerializedName("reviewsTotalCount"           ) var reviewsTotalCount           : String?           = null,
  @SerializedName("cityCenterPointDistance"     ) var cityCenterPointDistance     : Double?           = null,
  @SerializedName("cityCenterPointDistanceName" ) var cityCenterPointDistanceName : String?           = null,
  @SerializedName("hotelConcept"                ) var hotelConcept                : ArrayList<String> = arrayListOf(),
  @SerializedName("nearByHotels"                ) var nearByHotels                : String?           = null,
  @SerializedName("covidInfo"                   ) var covidInfo                   : String?           = null,
  @SerializedName("imageTypes"                  ) var imageTypes                  : ArrayList<String> = arrayListOf(),
  @SerializedName("hotelAutocompleteIcon"       ) var hotelAutocompleteIcon       : String?           = null,
  @SerializedName("locationDistance"            ) var locationDistance            : String?           = null,
  @SerializedName("policies"                    ) var policies                    : Policies?         = Policies()

)