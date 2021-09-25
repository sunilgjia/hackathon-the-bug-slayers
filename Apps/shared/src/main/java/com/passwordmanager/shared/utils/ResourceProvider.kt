package com.passwordmanager.shared.utils

import androidx.annotation.ArrayRes
import androidx.annotation.StringRes
import java.io.File

/**
 * ResourceProvider
 */
interface ResourceProvider {

    fun getString(@StringRes resId: Int, vararg params: Any = emptyArray()): String

    fun getCacheDir(): File?

    fun getStringArray(@ArrayRes id: Int): Array<String>
}
