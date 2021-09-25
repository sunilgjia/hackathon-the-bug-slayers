package com.passwordmanager.shared.repository.network.api

import com.passwordmanager.shared.repository.models.CredModel
import com.passwordmanager.shared.repository.models.UserModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val GET_ALL_USER = "user/get-all-users/2"
private const val GET_CRED = "credential"
private const val DELETE_CRED = "user"

interface CredApi {
    @GET(GET_ALL_USER)
    suspend fun getAllUsers(
    ): Response<List<UserModel>>

    @GET(GET_CRED)
    suspend fun getAllUserCred(
        @Query("isShared") isShared: Boolean,
        @Query("UserId") userId: Int
    ): Response<List<CredModel>>

    @GET(DELETE_CRED)
    suspend fun deleteAccount(
        @Query("UserId") userId: Int
    ): Response<Boolean>
}
