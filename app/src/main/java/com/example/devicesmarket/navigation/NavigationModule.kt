package com.example.devicesmarket.navigation

import com.example.core.navigation.Navigation
import com.example.devicesmarket.navigation.NavigationImpl
import dagger.Binds
import dagger.Module

@Module
interface NavigationModule {

    @Binds
    fun bindNavigation(navigationImpl: NavigationImpl): Navigation
}