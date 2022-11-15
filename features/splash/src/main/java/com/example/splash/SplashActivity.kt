package com.example.splash

import android.os.Bundle
import com.example.core.di.ActivityWithAppComponent
import com.example.core.navigation.Navigation
import javax.inject.Inject

class SplashActivity : ActivityWithAppComponent() {

    @Inject
    lateinit var navigation: Navigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerSplashActivityComponent.builder().abstractAppComponent(appComponent).build().inject(this)
        navigation.toMainActivity(this)
    }
}