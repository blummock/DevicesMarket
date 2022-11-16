package com.example.devicesmarket.entry_activity.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.MarketList
import com.example.core.repo.MarketRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MarketActivityViewModel @Inject constructor(private val marketRepository: MarketRepository) : ViewModel() {

    private val _marketList = MutableLiveData<MarketList>()
    val marketList: LiveData<MarketList> = _marketList

    init {
        viewModelScope.launch {
            _marketList.postValue(marketRepository.getMarketList())
        }
    }


}