package com.example.core.repo

import com.example.core.data.MarketEntityList

interface MarketRepository {
    suspend fun getMarketList(): MarketEntityList?
}