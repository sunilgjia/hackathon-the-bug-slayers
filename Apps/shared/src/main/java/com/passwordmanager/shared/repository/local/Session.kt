package com.passwordmanager.shared.repository.local

interface Session {


    fun setUserDataUpdated(updated: Boolean)

    fun setDefaultVehicleDataUpdated(updated: Boolean)

    fun isUserDataUpdated(): Boolean

    fun isDefaultVehicleDataUpdated(): Boolean

    fun setLanguagePreference(language: String)

    fun getLanguagePreference(): String

    fun clearSession()

}
