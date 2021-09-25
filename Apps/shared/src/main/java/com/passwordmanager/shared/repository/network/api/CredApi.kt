package com.passwordmanager.shared.repository.network.api

import com.passwordmanager.shared.repository.models.UserModel
import retrofit2.Response
import retrofit2.http.GET

private const val GET_ALL_USER = "user/get-all-users/2"

interface CredApi {
    @GET(GET_ALL_USER)
    suspend fun getAllUsers(
    ): Response<List<UserModel>>
}
