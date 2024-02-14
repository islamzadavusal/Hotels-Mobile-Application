package com.islamzada.common.util

import android.net.Uri
import androidx.navigation.NavController

    fun NavController.accountToLogin(){
        val uri = Uri.parse("hotel://accountToLogin/")
        this.navigate(uri)
}

    fun NavController.toMain(){
        val uri = Uri.parse("hotel://toMain/")
        this.navigate(uri)
}