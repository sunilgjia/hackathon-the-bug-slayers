package com.passwordmanager.shared.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.passwordmanager.shared.repository.models.ApiResponse
import com.passwordmanager.shared.repository.models.CustomerModel
import com.passwordmanager.shared.repository.network.api.CustomerApi
import javax.inject.Inject

class CustomerRepository @Inject constructor(
    private val customerApi: CustomerApi
) {

    fun getMe(callBack: ((ApiResponse<CustomerModel>) -> Unit)? = null): LiveData<ApiResponse<CustomerModel>> {
        val data = MutableLiveData<ApiResponse<CustomerModel>>()
        customerApi.getMe().enqueue(ApiResponse.getCallback(data, callBack = callBack))
        return data
    }
}
