package com.passwordmanager.shared.utils

import android.app.Activity
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToast(message: String, duration: Int = Toast.LENGTH_SHORT): Toast? {
    return Toast.makeText(requireContext(), message, duration).apply { show() }
}

fun Activity.showToast(message: String, duration: Int = Toast.LENGTH_SHORT): Toast? {
    return Toast.makeText(this, message, duration).apply { show() }
}
