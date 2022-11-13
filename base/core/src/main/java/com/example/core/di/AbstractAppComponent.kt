package com.example.core.di

import com.example.core.navigation.Navigation
import com.example.core.repo.MarketRepository

interface AbstractAppComponent {

    fun provideNavigation(): Navigation

    fun provideMarketRepository(): MarketRepository
}