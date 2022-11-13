package com.example.core

import com.example.core.navigation.Navigation

interface AbstractAppComponent {

    fun provideNavigation(): Navigation
}