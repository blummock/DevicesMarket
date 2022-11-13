package com.example.network

import com.example.core.data.BasketList
import com.example.core.data.MarketList
import com.example.core.data.ProductEntity
import com.example.core.repo.BasketRepository
import com.example.core.repo.MarketRepository
import com.example.core.repo.ProductRepository
import retrofit2.http.GET


interface MarketApi : MarketRepository, ProductRepository, BasketRepository {

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    override suspend fun getMarketList(): MarketList

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    override suspend fun getProduct(): ProductEntity

    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    override suspend fun getBasketList(): BasketList
}