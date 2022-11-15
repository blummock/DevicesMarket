package com.example.productdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.data.ProductEntity
import com.example.core.repo.ProductRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductDetailsViewModel @Inject constructor(private val productRepository: ProductRepository) : ViewModel() {

    private val _productEntity = MutableLiveData<ProductEntity>()
    val productEntity: LiveData<ProductEntity> = _productEntity


    fun load(int: Int) {
        viewModelScope.launch {
            _productEntity.postValue(productRepository.getProduct())
        }
    }


}