package com.denybrabo.imgurcats.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.denybrabo.imgurcats.model.DataModel
import com.denybrabo.imgurcats.model.DataRepository

class AnimalsViewModel: ViewModel() {

    private var _animals: MutableLiveData<DataModel>? = null
    var animalsModel: LiveData<DataModel>? = _animals

    fun getAnimals(search: String): LiveData<DataModel>?{
        _animals = DataRepository().getAnimals(search)
        return _animals
    }
}