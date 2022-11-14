package com.example.devicesmarket.main_market.di

import com.example.core.di.ViewModelFactory
import com.example.devicesmarket.main_market.ui.MarketActivityViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
object MarketActivityViewModelModule {

    @Provides
    fun provideViewFactory(provider: Provider<MarketActivityViewModel>): ViewModelFactory = ViewModelFactory(provider)
}