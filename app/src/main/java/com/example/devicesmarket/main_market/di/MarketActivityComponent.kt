package com.example.devicesmarket.main_market.di

import com.example.core.di.AbstractAppComponent
import com.example.devicesmarket.main_market.ui.MainActivity
import dagger.Component

@Component(
    dependencies = [AbstractAppComponent::class],
    modules = [MarketActivityViewModelModule::class]
)
interface MarketActivityComponent {
    fun inject(activity: MainActivity)
}
