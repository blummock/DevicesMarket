package com.example.devicesmarket.navigation

import android.app.Activity
import android.content.Intent
import com.example.core.navigation.Navigation
import com.example.devicesmarket.entry_activity.ui.MainActivity
import com.example.mycart.MyCartActivity
import com.example.productdetails.ui.ProductDetailsActivity
import javax.inject.Inject

class NavigationImpl @Inject constructor() : Navigation {

    private fun toActivity(currentActivity: Activity, cls: Class<*>) {
        val myIntent = Intent(currentActivity, cls)
        currentActivity.startActivity(myIntent)
        currentActivity.finish()
    }

    override fun toMainActivity(currentActivity: Activity) =
        toActivity(currentActivity, MainActivity::class.java)

    override fun toMyCartActivity(currentActivity: Activity) =
        toActivity(currentActivity, MyCartActivity::class.java)

    override fun toProductDetailsActivity(currentActivity: Activity) =
        toActivity(currentActivity, ProductDetailsActivity::class.java)
}