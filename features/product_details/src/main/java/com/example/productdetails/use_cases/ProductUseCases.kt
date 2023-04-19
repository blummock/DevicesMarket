package com.example.productdetails.use_cases

import com.example.core.data.BasketEntityList
import com.example.core.data.ProductEntity
import com.example.core.exceptions.EmptyResponseException
import com.example.core.repo.ProductRepository
import com.example.core.use_cases.UseCases
import javax.inject.Inject

class ProductUseCases @Inject constructor(private val repository: ProductRepository) : UseCases<ProductEntity> {

    override suspend fun fetch() = kotlin.runCatching { repository.getProduct() ?: throw EmptyResponseException() }
        .onSuccess { Result.success(it) }
        .onFailure { Result.failure<BasketEntityList>(it) }
}