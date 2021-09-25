/*
 * Copyright (c) 2020. Binate Station Private Limited. All rights reserved.
 */

package com.passwordmanager.shared

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class SharedViewModel @Inject constructor() : ViewModel() {

    private val _refreshCartCount = MutableLiveData<Boolean>()

    val refreshCartCount: LiveData<Boolean>
        get() = _refreshCartCount

    fun setRefreshCartCount(refresh: Boolean) {
        _refreshCartCount.value = refresh
    }
}
