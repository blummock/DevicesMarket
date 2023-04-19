package com.example.core.di

import com.example.core.data.BasketEntityList
import com.example.core.data.MarketEntityList
import com.example.core.data.ProductEntity
import com.example.core.navigation.Navigation
import com.example.core.use_cases.UseCases

interface AbstractActivityComponent {

    fun provideNavigation(): Navigation

    fun provideBasketUseCases(): UseCases<BasketEntityList>

    fun provideMarketUseCases(): UseCases<MarketEntityList>

    fun provideProductUseCases(): UseCases<ProductEntity>
}