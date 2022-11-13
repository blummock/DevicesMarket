package com.example.devicesmarket

import com.example.core.di.AbstractAppComponent
import com.example.core.ActivityScope
import dagger.Component

@ActivityScope
@Component(dependencies = [AbstractAppComponent::class])
interface ActivityComponent {
    fun inject(activity: MainActivity)
}
