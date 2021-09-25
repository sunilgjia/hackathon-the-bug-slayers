package com.passwordmanager.shared.repository.network.api

import com.passwordmanager.shared.repository.models.CustomerModel
import retrofit2.Call
import retrofit2.http.GET

private const val END_URL_CUSTOMER = "customers/me"

interface CustomerApi {
    @GET(END_URL_CUSTOMER)
    fun getMe(
    ): Call<CustomerModel>
}
