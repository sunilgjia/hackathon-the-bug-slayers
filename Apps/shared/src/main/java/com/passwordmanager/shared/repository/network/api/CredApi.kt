package com.passwordmanager.shared.repository.network.api

import com.passwordmanager.shared.repository.models.CredModel
import com.passwordmanager.shared.repository.models.CustomerModel
import com.passwordmanager.shared.repository.models.UserModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

private const val GET_ALL_USER = "user/get-all-users/2"

interface CredApi {
    @GET(GET_ALL_USER)
    fun getAllUsers(
    ): Response<List<UserModel>>
}
