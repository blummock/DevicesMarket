package com.example.devicesmarket

import android.app.Application
import com.example.devicesmarket.entry_activity.di.AppComponent
import com.example.devicesmarket.entry_activity.di.DaggerAppComponent
import com.example.network.repository.DaggerRepositoryComponent

class MyApp : Application() {

    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent =
            DaggerAppComponent.builder().abstractRepositoryComponent(DaggerRepositoryComponent.create()).build()
    }
}