package com.example.core.repo

interface AbstractRepositoryComponent {

    fun provideMarketRepository(): MarketRepository

    fun provideDeviceRepository(): ProductRepository

    fun provideBasketRepository(): BasketRepository
}