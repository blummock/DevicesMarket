package com.example.core.di

import com.example.core.navigation.Navigation

interface AbstractAppComponent {

    fun provideNavigation(): Navigation
}