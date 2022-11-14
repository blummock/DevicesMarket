package com.example.network

import com.example.core.repo.BasketRepository
import com.example.core.repo.MarketRepository
import com.example.core.repo.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
interface RepositoryModule {

    companion object {
        @Provides
        fun provideApi(retrofit: Retrofit) = retrofit.create(MarketApi::class.java)
    }

    @Binds
    fun provideMarketRepository(marketApi: MarketApi): MarketRepository

    @Binds
    fun provideDeviceRepository(marketApi: MarketApi): ProductRepository

    @Binds
    fun provideBasketRepository(marketApi: MarketApi): BasketRepository

}