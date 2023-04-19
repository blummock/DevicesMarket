package com.example.devicesmarket.entry_activity.di

import com.example.core.data.BasketEntityList
import com.example.core.data.MarketEntityList
import com.example.core.data.ProductEntity
import com.example.core.use_cases.UseCases
import com.example.devicesmarket.use_cases.UseCasesComponent
import dagger.Component

@Component(dependencies = [UseCasesComponent::class])
interface AppComponent {

    fun provideBasketUseCases(): UseCases<BasketEntityList>

    fun provideMarketUseCases(): UseCases<MarketEntityList>

    fun provideProductUseCases(): UseCases<ProductEntity>
}