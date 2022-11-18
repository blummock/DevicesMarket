package com.example.core.repo

import com.example.core.data.MarketList

interface MarketRepository {
    suspend fun getMarketList(): MarketList?
}