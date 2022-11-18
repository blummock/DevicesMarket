package com.example.devicesmarket.entry_activity.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.MarketList
import com.example.core.repo.BasketRepository
import com.example.core.repo.MarketRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MarketActivityViewModel @Inject constructor(
    private val marketRepository: MarketRepository,
    private val basketRepository: BasketRepository
) : ViewModel() {

    private val _marketList = MutableLiveData<MarketList>()
    val marketList: LiveData<MarketList> = _marketList

    private val _basketCount = MutableLiveData<Int>()
    val basketCount: LiveData<Int> = _basketCount

    init {
        viewModelScope.launch {
            marketRepository.getMarketList()?.also {
                _marketList.postValue(it)
            }
        }
        viewModelScope.launch {
            basketRepository.getBasketList()?.also {
                _basketCount.postValue(it.basket.size)
            }
        }
    }
}