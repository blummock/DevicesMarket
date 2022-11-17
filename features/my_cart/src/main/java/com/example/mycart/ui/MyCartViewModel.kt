package com.example.mycart.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.BasketList
import com.example.core.repo.BasketRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MyCartViewModel @Inject constructor(private val basketRepository: BasketRepository) : ViewModel() {

    private val _basketList = MutableLiveData<BasketList>()
    val basketList: LiveData<BasketList> = _basketList

    init {
        viewModelScope.launch {
            _basketList.postValue(basketRepository.getBasketList())
        }
    }
}