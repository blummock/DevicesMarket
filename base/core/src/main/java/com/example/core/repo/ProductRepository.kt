package com.example.core.repo

import com.example.core.data.ProductEntity

interface ProductRepository {
    suspend fun getProduct(): ProductEntity?
}