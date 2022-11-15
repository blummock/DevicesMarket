package com.example.splash

import com.example.core.di.AbstractAppComponent
import dagger.Component

@Component(dependencies = [AbstractAppComponent::class])
interface SplashActivityComponent {
    fun inject(splashActivity: SplashActivity)
}