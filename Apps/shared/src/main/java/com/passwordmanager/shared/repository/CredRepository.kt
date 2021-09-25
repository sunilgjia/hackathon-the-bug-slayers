package com.passwordmanager.shared.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.passwordmanager.shared.repository.models.ApiResponse
import com.passwordmanager.shared.repository.models.CredModel
import com.passwordmanager.shared.repository.models.UserModel
import com.passwordmanager.shared.repository.network.api.CredApi
import javax.inject.Inject

class CredRepository @Inject constructor(
    private val credApi: CredApi
) {

    suspend fun getAllUser(): ApiResponse<List<UserModel>> {
        return try {
            val response = credApi.getAllUsers()
            ApiResponse.create(response = response)
        } catch (e: Exception) {
            e.printStackTrace()
            ApiResponse.create(e.fillInStackTrace())
        }
    }
}
