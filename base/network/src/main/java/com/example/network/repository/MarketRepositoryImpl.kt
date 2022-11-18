package com.example.network.repository

import com.example.core.data.MarketList
import com.example.core.repo.Cache
import com.example.core.repo.MarketRepository
import com.example.core.repo.ResponseHandler
import com.example.network.NetApi
import javax.inject.Inject

class MarketRepositoryImpl @Inject constructor(
    private val netApi: NetApi,
    private val cache: Cache<MarketList>,
    private val responseHandler: ResponseHandler
) :
    MarketRepository {

    override suspend fun getMarketList(): MarketList? {
        return responseHandler.handle {
            cache.getOrUpdate {
                netApi.getMarketList()
            }
        }
    }
}