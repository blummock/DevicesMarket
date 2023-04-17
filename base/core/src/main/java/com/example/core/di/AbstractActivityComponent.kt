package com.example.core.di

import com.example.core.navigation.Navigation
import com.example.core.repo.BasketRepository
import com.example.core.repo.MarketRepository
import com.example.core.repo.ProductRepository

interface AbstractActivityComponent {

    fun provideNavigation(): Navigation

    fun provideMarketRepository(): MarketRepository

    fun provideProductRepository(): ProductRepository

    fun provideBasketRepository(): BasketRepository
}