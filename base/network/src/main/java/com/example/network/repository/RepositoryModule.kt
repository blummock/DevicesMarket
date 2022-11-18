package com.example.network.repository

import com.example.core.data.BasketList
import com.example.core.data.MarketList
import com.example.core.data.ProductEntity
import com.example.core.repo.*
import com.example.network.InMemoryCache
import com.example.network.NetApi
import com.example.network.ResponseHandlerImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
interface RepositoryModule {

    companion object {

        @Provides
        @Singleton
        fun provideApi(retrofit: Retrofit) = retrofit.create(NetApi::class.java)

        @Provides
        @Singleton
        fun provideCacheBasket(): Cache<BasketList> = InMemoryCache()

        @Provides
        @Singleton
        fun provideCacheDetails(): Cache<ProductEntity> = InMemoryCache()

        @Provides
        @Singleton
        fun provideCacheMarket(): Cache<MarketList> = InMemoryCache()

        @Provides
        @Singleton
        fun provideHandler(): ResponseHandler = ResponseHandlerImpl
    }


    @Binds
    fun provideBasketRepository(basketRepository: BasketRepositoryImpl): BasketRepository

    @Binds
    fun provideMarketRepository(marketRepository: MarketRepositoryImpl): MarketRepository

    @Binds
    fun provideDetailsRepository(productRepository: ProductRepositoryImpl): ProductRepository
}