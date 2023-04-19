package com.example.devicesmarket.use_cases

import com.example.core.data.BasketEntityList
import com.example.core.data.MarketEntityList
import com.example.core.data.ProductEntity
import com.example.core.di.AbstractRepositoryComponent
import com.example.core.use_cases.UseCases
import dagger.Component

@Component(
    modules = [UsesCasesModule::class],
    dependencies = [AbstractRepositoryComponent::class]
)
interface UseCasesComponent {

    fun provideBasketUseCases(): UseCases<BasketEntityList>

    fun provideMarketUseCases(): UseCases<MarketEntityList>

    fun provideProductUseCases(): UseCases<ProductEntity>
}