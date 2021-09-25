package com.passwordmanager.addaccount

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.passwordmanager.R
import com.passwordmanager.shared.repository.CredRepository
import com.passwordmanager.shared.repository.models.ApiErrorResponse
import com.passwordmanager.shared.repository.models.ApiNoNetworkResponse
import com.passwordmanager.shared.repository.models.ApiSuccessResponse
import com.passwordmanager.shared.repository.models.UserModel
import com.passwordmanager.shared.utils.ResourceProvider
import com.passwordmanager.shared.utils.SingleLiveEvent
import kotlinx.coroutines.launch
import java.util.ArrayList
import javax.inject.Inject

class AddAccountViewModel @Inject constructor(
    private val credRepository: CredRepository,
    private val resourceProvider: ResourceProvider
) : ViewModel() {
    private val _userListResponse = MutableLiveData<List<UserModel?>?>()
    val userListResponse : LiveData<List<UserModel?>?> = _userListResponse

    private val _showProgress = MutableLiveData<Boolean>()
    val showProgress : LiveData<Boolean> = _showProgress

    private val _apiError = MutableLiveData<String>()
    val apiError : LiveData<String> = _apiError

    private val _noNetwork: SingleLiveEvent<String> = SingleLiveEvent()
    val noNetwork: LiveData<String> = _noNetwork

    fun getUserList(){
        viewModelScope.launch {
            _showProgress.postValue(true)
            when(val results = credRepository.getAllUser()){
                is ApiSuccessResponse ->{
                    _showProgress.postValue(false)
                    _userListResponse.postValue(results.body)
                }
                is ApiErrorResponse ->{
                    _apiError.postValue(results.errorMessage)
                    _showProgress.postValue(false)
                }
            }
        }
    }

    fun addAccount(
        name: String,
        email: String,
        password: String,
        description: String,
        selectedUserList: ArrayList<UserModel?>
    ) {
        viewModelScope.launch {

        }
    }

    fun getCredById(id: Int){
        if(id != 0) {
            viewModelScope.launch {
                _showProgress.postValue(true)
                when (val results = credRepository.getCredById(id)) {
                    is ApiSuccessResponse -> {
                        _showProgress.postValue(false)
                    }
                    is ApiErrorResponse -> {
                        _apiError.postValue(results.errorMessage)
                        _showProgress.postValue(false)
                    }
                    is ApiNoNetworkResponse -> {
                        _showProgress.postValue(false)
                        _noNetwork.postValue(resourceProvider.getString(R.string.no_network_message))
                    }
                }
            }
        }
    }
}