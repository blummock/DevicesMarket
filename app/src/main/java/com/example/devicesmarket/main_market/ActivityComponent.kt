package com.example.devicesmarket.main_market

import com.example.core.di.AbstractAppComponent
import dagger.Component

@Component(dependencies = [AbstractAppComponent::class])
interface ActivityComponent {
    fun inject(activity: MainActivity)
}
