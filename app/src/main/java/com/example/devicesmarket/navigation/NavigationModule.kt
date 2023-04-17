package com.example.devicesmarket.navigation

import androidx.fragment.app.FragmentManager
import com.example.core.navigation.Navigation
import dagger.Module
import dagger.Provides

@Module
object NavigationModule {

    @Provides
    fun bindNavigation(fragmentManager: FragmentManager): Navigation = NavigationImpl(fragmentManager)
}