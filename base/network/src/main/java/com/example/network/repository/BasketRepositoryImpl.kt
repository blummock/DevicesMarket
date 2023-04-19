package com.example.network.repository

import com.example.core.data.BasketEntityList
import com.example.core.repo.BasketRepository
import com.example.core.repo.Cache
import com.example.core.repo.ResponseHandler
import com.example.network.NetApi
import com.example.network.adapters.toEntity
import javax.inject.Inject

class BasketRepositoryImpl @Inject constructor(
    private val netApi: NetApi, private val cache: Cache<BasketEntityList>, private val responseHandler: ResponseHandler
) : BasketRepository {

    override suspend fun getBasketList(): BasketEntityList? {
        return responseHandler.handle {
            cache.getOrUpdate {
                netApi.getBasketList().toEntity()
            }
        }
    }
}