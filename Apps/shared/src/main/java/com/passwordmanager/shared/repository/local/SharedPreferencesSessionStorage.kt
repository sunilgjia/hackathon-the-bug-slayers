package com.passwordmanager.shared.repository.local

import android.content.Context
import com.passwordmanager.shared.utils.Constants
import javax.inject.Inject

private const val KEY_SESSION = "SESSION"

// @Inject tells Dagger how to provide instances of this type
class SharedPreferencesSessionStorage @Inject constructor(context: Context) : Session {

    private val sharedPreferences = context.getSharedPreferences(KEY_SESSION, Context.MODE_PRIVATE)

    override fun setUserDataUpdated(updated: Boolean) {
        sharedPreferences.edit().putBoolean(Constants.Keys.IS_USER_DATA_UPDATED, updated).apply()
    }

    override fun setDefaultVehicleDataUpdated(updated: Boolean) {
        sharedPreferences.edit().putBoolean(Constants.Keys.IS_DEFAULT_VEHICLE_DATA_UPDATED, updated)
            .apply()
    }

    override fun isUserDataUpdated(): Boolean {
        return sharedPreferences.getBoolean(Constants.Keys.IS_USER_DATA_UPDATED, false)
    }

    override fun isDefaultVehicleDataUpdated(): Boolean {
        return sharedPreferences.getBoolean(Constants.Keys.IS_DEFAULT_VEHICLE_DATA_UPDATED, false)
    }

    override fun setLanguagePreference(language: String) {
        sharedPreferences.edit().putString(Constants.Keys.LANGUAGE, language).apply()
    }

    override fun getLanguagePreference(): String {
        return sharedPreferences.getString(Constants.Keys.LANGUAGE, "") ?: ""
    }

    override fun clearSession() {
        sharedPreferences.edit()?.clear()?.apply()
    }
}
