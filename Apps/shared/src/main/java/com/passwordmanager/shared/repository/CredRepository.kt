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

    suspend fun getCred(isShared : Boolean): ApiResponse<List<CredModel>> {
        return try {
            val response = credApi.getAllUserCred(isShared,2)
            ApiResponse.create(response = response)
        } catch (e: Exception) {
            e.printStackTrace()
            ApiResponse.create(e.fillInStackTrace())
        }
    }

    suspend fun deleteUser(isShared : Int): ApiResponse<Boolean> {
        return try {
            val response = credApi.deleteAccount(isShared)
            ApiResponse.create(response = response)
        } catch (e: Exception) {
            e.printStackTrace()
            ApiResponse.create(e.fillInStackTrace())
        }
    }
}
