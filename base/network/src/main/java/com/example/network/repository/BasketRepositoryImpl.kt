package com.example.network.repository

import com.example.core.data.BasketList
import com.example.core.repo.BasketRepository
import com.example.core.repo.Cache
import com.example.core.repo.ResponseHandler
import com.example.network.NetApi
import javax.inject.Inject

class BasketRepositoryImpl @Inject constructor(
    private val netApi: NetApi, private val cache: Cache<BasketList>, private val responseHandler: ResponseHandler
) : BasketRepository {

    override suspend fun getBasketList(): BasketList? {
        return responseHandler.handle {
            cache.getOrUpdate {
                netApi.getBasketList()
            }
        }
    }
}