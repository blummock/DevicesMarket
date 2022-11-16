package com.example.devicesmarket.entry_activity.di

import com.example.core.di.ViewModelFactory
import com.example.devicesmarket.entry_activity.ui.MarketActivityViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
object MarketActivityViewModelModule {

    @Provides
    fun provideViewFactory(provider: Provider<MarketActivityViewModel>): ViewModelFactory = ViewModelFactory(provider)
}