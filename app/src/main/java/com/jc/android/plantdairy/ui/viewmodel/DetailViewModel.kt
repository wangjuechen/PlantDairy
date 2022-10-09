package com.jc.android.plantdairy.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jc.android.plantdairy.data.PlantRepository
import com.jc.android.plantdairy.model.Plant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: PlantRepository
) : ViewModel() {

//    var plantId : String = ""

    private val _plantLiveData = MutableLiveData<Plant>()

    // The external immutable LiveData for the request status
    val plantLiveData: LiveData<Plant> = _plantLiveData

    fun getPlant(plantId: String) {
        viewModelScope.launch {
            _plantLiveData.value = repository.getPlant(plantId)
        }
    }
//    fun savePlantId(id: String) {
//        plantId = id
//    }
}