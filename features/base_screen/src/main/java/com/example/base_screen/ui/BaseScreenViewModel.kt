package com.example.base_screen.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.BasketEntityList
import com.example.core.data.MarketEntityList
import com.example.core.use_cases.UseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

class BaseScreenViewModel @Inject constructor(
    private val marketUseCases: UseCases<MarketEntityList>,
    private val basketUseCases: UseCases<BasketEntityList>
) : ViewModel() {

    private val _marketList = MutableLiveData<MarketEntityList>()
    val marketList: LiveData<MarketEntityList> = _marketList

    private val _basketCount = MutableLiveData<Int>()
    val basketCount: LiveData<Int> = _basketCount

    init {
        viewModelScope.launch {
            marketUseCases.fetch().onSuccess {
                _marketList.postValue(it)
            }
        }
        viewModelScope.launch {
            basketUseCases.fetch().onSuccess {
                _basketCount.postValue(it.basket.size)
            }
        }
    }
}