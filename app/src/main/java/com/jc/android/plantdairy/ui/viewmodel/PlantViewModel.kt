package com.jc.android.plantdairy.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jc.android.plantdairy.data.PlantRepository
import com.jc.android.plantdairy.model.Plant


import kotlinx.coroutines.launch
import javax.inject.Inject

class PlantViewModel @Inject constructor(
    private val repository: PlantRepository
) : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _plantListLiveData = MutableLiveData<List<Plant>>()

    // The external immutable LiveData for the request status
    val plantListLiveData: LiveData<List<Plant>> = _plantListLiveData

    init {
        getPlants()
    }

    private fun getPlants() {
        viewModelScope.launch {
            _plantListLiveData.value = repository.getPlant()
        }
    }
}