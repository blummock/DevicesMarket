package com.example.devicesmarket

import android.app.Application
import com.example.core.AbstractApp
import com.example.core.AbstractAppComponent
import com.example.core.navigation.AppNavigation
import com.example.core.navigation.Navigation

class MyApp : Application(), AppNavigation, AbstractApp {

    private var navigation: Navigation? = null
    private var appComponent: AbstractAppComponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
        navigation = NavigationImpl()
    }

    override fun getAppComponent(): AbstractAppComponent {
        return appComponent!!
    }

    override fun getNavigation(): Navigation {
        return navigation!!
    }
}