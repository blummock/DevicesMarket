package com.example.devicesmarket.entry_activity.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.core.di.AbstractActivity
import com.example.core.di.AbstractActivityComponent
import com.example.core.navigation.Navigation
import com.example.devicesmarket.MyApp
import com.example.devicesmarket.databinding.ActivityMainBinding
import com.example.devicesmarket.entry_activity.di.DaggerMainActivityComponent
import javax.inject.Inject


class MainActivity : AppCompatActivity(), AbstractActivity {

    private lateinit var component: AbstractActivityComponent
    override fun getComponent() = component


    @Inject
    lateinit var navigation: Navigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        component = DaggerMainActivityComponent
            .builder()
            .fragmentManager(supportFragmentManager)
            .appComponent((application as MyApp).appComponent)
            .build().apply { inject(this@MainActivity) }
        navigation.toBaseFragment(null)
    }
}