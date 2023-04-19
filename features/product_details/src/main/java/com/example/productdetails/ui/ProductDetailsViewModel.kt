package com.example.productdetails.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.ProductEntity
import com.example.core.use_cases.UseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductDetailsViewModel @Inject constructor(private val useCases: UseCases<ProductEntity>) : ViewModel() {

    private val _productEntity = MutableLiveData<ProductEntity>()
    val productEntity: LiveData<ProductEntity> = _productEntity


    fun load(int: Int) {
        viewModelScope.launch {
            useCases.fetch().onSuccess {
                _productEntity.postValue(it)
            }
        }
    }


}