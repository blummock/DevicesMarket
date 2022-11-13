package com.example.network

import com.example.core.repo.BasketRepository
import com.example.core.repo.MarketRepository
import com.example.core.repo.ProductRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RepositoryModule {

    @Provides
    fun provideMarketRepository(retrofit: Retrofit): MarketRepository = retrofit.create(MarketApi::class.java)

    @Provides
    fun provideDeviceRepository(retrofit: Retrofit): ProductRepository = retrofit.create(MarketApi::class.java)

    @Provides
    fun provideBasketRepository(retrofit: Retrofit): BasketRepository = retrofit.create(MarketApi::class.java)

}