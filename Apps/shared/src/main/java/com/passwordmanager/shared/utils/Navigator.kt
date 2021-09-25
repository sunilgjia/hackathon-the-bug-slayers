package com.passwordmanager.shared.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri

object Navigator {

    fun navigate(context: Context, uriString: String, shouldFinishAffinity: Boolean = true) {
        try {
            val intent = Intent(Intent.ACTION_MAIN, Uri.parse(uriString))
            context.startActivity(intent)
            if (shouldFinishAffinity && context is Activity) {
                context.finishAffinity()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
