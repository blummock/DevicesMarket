package com.example.devicesmarket.navigation

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.base_screen.ui.BaseScreenFragment
import com.example.core.navigation.Navigation
import com.example.devicesmarket.R
import com.example.mycart.ui.MyCartFragment
import com.example.productdetails.ui.ProductDetailsFragment
import javax.inject.Inject

class NavigationImpl @Inject constructor(private val manager: FragmentManager) : Navigation {

    override fun back() {
        manager.popBackStack()
    }

    override fun init() {
        manager.beginTransaction()
            .replace(R.id.host, BaseScreenFragment::class.java, null)
            .commit()
    }

    override fun toBaseFragment(bundle: Bundle?) {
        manager.beginTransaction()
            .replace(R.id.host, BaseScreenFragment::class.java, bundle)
            .addToBackStack(null)
            .commit()
    }

    override fun toMyCartFragment(bundle: Bundle?) {
        manager.beginTransaction()
            .replace(R.id.host, MyCartFragment::class.java, bundle)
            .addToBackStack(null)
            .commit()
    }

    override fun toProductDetailsFragment(bundle: Bundle?) {
        manager.beginTransaction()
            .replace(R.id.host, ProductDetailsFragment::class.java, bundle)
            .addToBackStack(null)
            .commit()
    }
}