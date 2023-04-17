package com.example.devicesmarket

import com.example.core.di.AbstractRepositoryComponent
import com.example.core.repo.BasketRepository
import com.example.core.repo.MarketRepository
import com.example.core.repo.ProductRepository
import dagger.Component

@Component(
    dependencies = [AbstractRepositoryComponent::class],
)
interface AppComponent {

    fun provideMarketRepository(): MarketRepository

    fun provideProductRepository(): ProductRepository

    fun provideBasketRepository(): BasketRepository
}