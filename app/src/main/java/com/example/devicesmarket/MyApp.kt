package com.example.devicesmarket

import android.app.Application
import com.example.core.di.AbstractApp
import com.example.core.di.AbstractAppComponent
import com.example.network.DaggerRepositoryComponent

class MyApp : Application(), AbstractApp {

    private var appComponent: AbstractAppComponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .abstractRepositoryComponent(DaggerRepositoryComponent.create())
            .build()
    }

    override fun getAppComponent(): AbstractAppComponent {
        return appComponent!!
    }

}