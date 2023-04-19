package com.example.mycart.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.BasketEntityList
import com.example.core.use_cases.UseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

class MyCartViewModel @Inject constructor(private val useCases: UseCases<BasketEntityList>) : ViewModel() {

    private val _basketList = MutableLiveData<BasketEntityList>()
    val basketList: LiveData<BasketEntityList> = _basketList

    init {
        viewModelScope.launch {
            useCases.fetch().onSuccess {
                _basketList.postValue(it)
            }
        }
    }
}