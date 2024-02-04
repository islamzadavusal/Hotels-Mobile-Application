package com.islamzada.common.util

import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ErrorMessage {
    companion object {
        fun getLocalizedMessage(errorCode : String) : String {
            return when(errorCode) {
                "ERROR_WEAK_PASSWORD" -> "Enter a 6-digit password"
                "ERROR_INVALID_EMAIL" -> "Enter a valid Email"
                else-> "Check your information again."
            }
        }
        fun getEmptyFieldMessage(): String {
            return "Please fill in all fields"
        }
    }
}

fun Fragment.showMessage(title :String, detail : String) {
    MaterialAlertDialogBuilder(requireContext())
        .setTitle(title)
        .setMessage(detail)
        .setPositiveButton("Okey")  { dialog, which->

        }
        .show()
}