package com.example.devicesmarket.navigation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.base_screen.ui.BaseScreenFragment
import com.example.core.navigation.Navigation
import com.example.devicesmarket.R
import com.example.devicesmarket.entry_activity.ui.MainActivity
import com.example.mycart.ui.MyCartActivity
import com.example.productdetails.ui.ProductDetailsActivity
import javax.inject.Inject

class NavigationImpl @Inject constructor(private val manager: FragmentManager) : Navigation {


    private fun toActivity(currentActivity: Activity, cls: Class<*>, bundle: Bundle = Bundle()) {
        val myIntent = Intent(currentActivity, cls)
        myIntent.putExtras(bundle)
        currentActivity.startActivity(myIntent)
        currentActivity.finish()
    }

    override fun toBaseFragment(bundle: Bundle?) {
        manager.beginTransaction()
            .replace(R.id.host, BaseScreenFragment::class.java, bundle)
            .commit()
    }

    override fun toMainActivity(currentActivity: Activity) =
        toActivity(currentActivity, MainActivity::class.java)

    override fun toMyCartActivity(currentActivity: Activity) =
        toActivity(currentActivity, MyCartActivity::class.java)

    override fun toProductDetailsActivity(currentActivity: Activity, bundle: Bundle) =
        toActivity(currentActivity, ProductDetailsActivity::class.java, bundle)
}