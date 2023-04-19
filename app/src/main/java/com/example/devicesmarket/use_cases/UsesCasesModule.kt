package com.example.devicesmarket.use_cases

import com.example.base_screen.use_cases.MarketUseCases
import com.example.core.data.BasketEntityList
import com.example.core.data.MarketEntityList
import com.example.core.data.ProductEntity
import com.example.core.use_cases.UseCases
import com.example.mycart.use_cases.BasketUseCases
import com.example.productdetails.use_cases.ProductUseCases
import dagger.Binds
import dagger.Module

@Module
interface UsesCasesModule {

    @Binds
    fun bindBasketUseCases(useCases: BasketUseCases): UseCases<BasketEntityList>

    @Binds
    fun bindMarketUseCases(useCases: MarketUseCases): UseCases<MarketEntityList>

    @Binds
    fun bindsProductUseCases(useCases: ProductUseCases): UseCases<ProductEntity>

}