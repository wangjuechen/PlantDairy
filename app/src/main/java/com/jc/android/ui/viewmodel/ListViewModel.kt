package com.jc.android.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jc.android.data.PlantRepository
import com.jc.android.data.model.MarsPhoto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val repository: PlantRepository
): ViewModel() {

    private val _plantListLiveData = MutableLiveData<List<MarsPhoto>>()
    val plantListLiveData: LiveData<List<MarsPhoto>> = _plantListLiveData

    init {
        getPlants()
    }

    private fun getPlants() {
        viewModelScope.launch {
            _plantListLiveData.value = repository.getPlants()
        }
    }
}