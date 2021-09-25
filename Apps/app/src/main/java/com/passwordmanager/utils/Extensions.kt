package com.passwordmanager.utils

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import com.passwordmanager.R

fun Context.showAlert(
    message: String,
    okListener: DialogInterface.OnClickListener
) {
    AlertDialog.Builder(this)
        .setMessage(message)
        .setPositiveButton(getString(R.string.button_ok), okListener)
        .setNegativeButton(getString(R.string.button_cancel), null)
        .create()
        .show()
}