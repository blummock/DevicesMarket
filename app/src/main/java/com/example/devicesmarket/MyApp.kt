package com.example.devicesmarket

import android.app.Application
import com.example.core.navigation.AppNavigation
import com.example.core.navigation.Navigation

class MyApp : Application(), AppNavigation {

    private var navigation: Navigation? = null

    override fun onCreate() {
        super.onCreate()
        navigation = NavigationImpl()
    }

    override fun getNavigation(): Navigation {
        return navigation!!
    }
}