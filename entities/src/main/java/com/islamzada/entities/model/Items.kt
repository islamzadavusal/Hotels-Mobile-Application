package com.islamzada.entities.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Items (

    val name: String? = null,
    val code: String? = null,
    val value: Boolean? = null,
    val type: String? = null,
    val position: Long? = null,
    val count: Long? = null

) : Parcelable