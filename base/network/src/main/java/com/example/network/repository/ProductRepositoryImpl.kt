package com.example.network.repository

import com.example.core.data.ProductEntity
import com.example.core.repo.Cache
import com.example.core.repo.ProductRepository
import com.example.core.repo.ResponseHandler
import com.example.network.NetApi
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val netApi: NetApi,
    private val cache: Cache<ProductEntity>,
    private val responseHandler: ResponseHandler
) :
    ProductRepository {
    override suspend fun getProduct(): ProductEntity? {
        return responseHandler.handle {
            cache.getOrUpdate {
                netApi.getProduct()
            }
        }
    }
}