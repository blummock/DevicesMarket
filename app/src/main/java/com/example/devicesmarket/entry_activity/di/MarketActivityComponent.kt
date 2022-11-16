package com.example.devicesmarket.entry_activity.di

import com.example.core.di.AbstractAppComponent
import com.example.devicesmarket.entry_activity.ui.MainActivity
import dagger.Component

@Component(
    dependencies = [AbstractAppComponent::class],
    modules = [MarketActivityViewModelModule::class]
)
interface MarketActivityComponent {
    fun inject(activity: MainActivity)
}
