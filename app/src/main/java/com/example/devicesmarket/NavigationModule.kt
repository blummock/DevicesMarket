package com.example.devicesmarket

import com.example.core.navigation.Navigation
import dagger.Binds
import dagger.Module

@Module
interface NavigationModule {

    @Binds
    fun bindNavigation(navigationImpl: NavigationImpl): Navigation
}