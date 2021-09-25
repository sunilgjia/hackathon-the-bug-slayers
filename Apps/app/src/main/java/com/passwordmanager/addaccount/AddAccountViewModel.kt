package com.passwordmanager.addaccount

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.passwordmanager.shared.repository.CredRepository
import com.passwordmanager.shared.repository.models.ApiErrorResponse
import com.passwordmanager.shared.repository.models.ApiSuccessResponse
import com.passwordmanager.shared.repository.models.UserModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddAccountViewModel @Inject constructor(
    private val credRepository: CredRepository
) : ViewModel() {
    private val _userListResponse = MutableLiveData<List<UserModel?>?>()
    val userListResponse : LiveData<List<UserModel?>?> = _userListResponse

    private val _showProgress = MutableLiveData<Boolean>()
    val showProgress : LiveData<Boolean> = _showProgress

    private val _apiError = MutableLiveData<String>()
    val apiError : LiveData<String> = _apiError

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
}