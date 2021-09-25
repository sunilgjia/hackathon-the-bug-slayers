package com.passwordmanager.accountslist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.passwordmanager.R
import com.passwordmanager.shared.repository.CredRepository
import com.passwordmanager.shared.repository.models.*
import com.passwordmanager.shared.utils.ResourceProvider
import com.passwordmanager.shared.utils.SingleLiveEvent
import kotlinx.coroutines.launch
import javax.inject.Inject

class AccountListViewModel @Inject constructor(
    private val credRepository: CredRepository,
    private val resourceProvider: ResourceProvider
) :
    ViewModel() {

    private val _apiError: SingleLiveEvent<String> = SingleLiveEvent()
    val apiError: LiveData<String> = _apiError

    private val _noNetwork: SingleLiveEvent<String> = SingleLiveEvent()
    val noNetwork: LiveData<String> = _noNetwork

    private val _noData: SingleLiveEvent<Boolean> = SingleLiveEvent()
    val noData: LiveData<Boolean> = _noData

    private val _credListResponse = MutableLiveData<List<CredModel?>?>()
    val credListResponse: LiveData<List<CredModel?>?> = _credListResponse

    private val _deleteResponse = MutableLiveData<Boolean?>()
    val deleteResponse: LiveData<Boolean?> = _deleteResponse

    fun setType(isShared: Boolean?) {
        isShared?.let {
            viewModelScope.launch {
                val response =
                    credRepository.getCred(it)
                when (response) {
                    is ApiSuccessResponse -> {
                        _credListResponse.postValue(response.body)
                    }
                    is ApiErrorResponse -> {
                        _apiError.postValue(response.errorMessage)
                    }
                    is ApiNoNetworkResponse -> {
                        _noNetwork.postValue(resourceProvider.getString(R.string.no_network_message))
                    }
                    is ApiEmptyResponse -> {
                        _noData.postValue(true)
                    }
                }
            }
        }
    }

    fun deleteAccount(userId : Int){
        viewModelScope.launch {
            val response =
                credRepository.deleteUser(userId)
            when (response) {
                is ApiSuccessResponse -> {
                    _deleteResponse.postValue(response.body)
                }
                is ApiErrorResponse -> {
                    _apiError.postValue(response.errorMessage)
                }
                is ApiNoNetworkResponse -> {
                    _noNetwork.postValue(resourceProvider.getString(R.string.no_network_message))
                }
                is ApiEmptyResponse -> {
                    _noData.postValue(true)
                }
            }
        }
    }
}