package com.jc.android.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jc.android.network.MarsApi
import kotlinx.coroutines.launch

class ListViewModal : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status

    init {
        getMarsPhotos()
    }

    private fun getMarsPhotos() {
        viewModelScope.launch {
            // We should call this on background thread
            val listResult = MarsApi.retrofitService.getPhotos()
            _status.value = "Success: ${listResult.size} Mars photos retrieved"
        }
    }
}