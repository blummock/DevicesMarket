package com.example.devicesmarket.entry_activity.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.MutableLiveData
import com.example.core.di.AbstractActivity
import com.example.core.di.AbstractActivityComponent
import com.example.core.navigation.Navigation
import com.example.devicesmarket.MyApp
import com.example.devicesmarket.databinding.ActivityMainBinding
import com.example.devicesmarket.entry_activity.di.DaggerMainActivityComponent
import javax.inject.Inject


class MainActivity : AppCompatActivity(), AbstractActivity {

    @Inject
    lateinit var navigation: Navigation

    val fragmentIsReady = MutableLiveData(true)

    private lateinit var component: AbstractActivityComponent
    override fun getComponent() = component

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val splashScreen = installSplashScreen()
        splashScreen.setKeepOnScreenCondition {
            fragmentIsReady.value ?: true
        }
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        component = DaggerMainActivityComponent
            .builder()
            .fragmentManager(supportFragmentManager)
            .appComponent((application as MyApp).appComponent)
            .build().apply { inject(this@MainActivity) }
        navigation.init()
    }

    override fun fragmentIsReady() {
        fragmentIsReady.postValue(false)
    }
}