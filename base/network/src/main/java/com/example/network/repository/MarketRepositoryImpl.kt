package com.example.network.repository

import com.example.core.data.MarketEntityList
import com.example.core.repo.Cache
import com.example.core.repo.MarketRepository
import com.example.core.repo.ResponseHandler
import com.example.network.NetApi
import com.example.network.adapters.toEntity
import javax.inject.Inject

class MarketRepositoryImpl @Inject constructor(
    private val netApi: NetApi,
    private val cache: Cache<MarketEntityList>,
    private val responseHandler: ResponseHandler
) :
    MarketRepository {

    override suspend fun getMarketList(): MarketEntityList? {
        return responseHandler.handle {
            cache.getOrUpdate {
                netApi.getMarketList().toEntity()
            }
        }
    }
}