package com.passwordmanager.shared.utils

import android.content.Context
import java.io.File

class ResourceProviderImpl(private val context: Context) : ResourceProvider {

    override fun getString(resId: Int, vararg params: Any): String {
        return if (params.isEmpty()) {
            context.getString(resId)
        } else {
            context.getString(resId, *params)
        }
    }

    override fun getCacheDir(): File? {
        return context.cacheDir
    }

    override fun getStringArray(id: Int): Array<String> {
        return context.resources.getStringArray(id)
    }

}
