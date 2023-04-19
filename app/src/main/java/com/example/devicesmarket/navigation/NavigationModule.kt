package com.example.devicesmarket.navigation

import com.example.core.navigation.Navigation
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface NavigationModule {

    @Binds
    @Singleton
    fun bindNavigation(navigationImpl: NavigationImpl): Navigation
}