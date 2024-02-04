package com.islamzada.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Details (

  var id                          : String?           = null,
  var slug                        : String?           = null,
  var address                     : Address?          = Address(),
  var coordinate                  : Coordinate?       = Coordinate(),
  var description                 : String?           = null,
  var hotelInfoDescription        : String?           = null,
  var facilitiesGroup             : ArrayList<String> = arrayListOf(),
  var suitabilities               : ArrayList<String> = arrayListOf(),
  var hotelDescriptions           : ArrayList<String> = arrayListOf(),
  var extra                       : Extra?            = Extra(),
  var name                        : String?           = null,
  var images                      : ArrayList<String> = arrayListOf(),
  var starRating                  : Int?              = null,
  var reviewScore                 : Int?              = null,
  var reviews                     : String?           = null,
  var reviewInfo                  : String?           = null,
  var reviewScoreLocalized        : String?           = null,
  var generalReviewScoreNote      : String?           = null,
  var checkInTime                 : String?           = null,
  var checkOutTime                : String?           = null,
  var domestic                    : Boolean?          = null,
  var reviewsTotalCount           : String?           = null,
  var cityCenterPointDistance     : Double?           = null,
  var cityCenterPointDistanceName : String?           = null,
  var hotelConcept                : ArrayList<String> = arrayListOf(),
  var nearByHotels                : String?           = null,
  var covidInfo                   : String?           = null,
  var imageTypes                  : ArrayList<String> = arrayListOf(),
  var hotelAutocompleteIcon       : String?           = null,
  var locationDistance            : String?           = null,
  var policies                    : Policies?         = Policies()

) : Parcelable