package com.example.core.di

import com.example.core.repo.BasketRepository
import com.example.core.repo.MarketRepository
import com.example.core.repo.ProductRepository

interface AbstractRepositoryComponent {

    fun provideMarketRepository(): MarketRepository

    fun provideDeviceRepository(): ProductRepository

    fun provideBasketRepository(): BasketRepository
}