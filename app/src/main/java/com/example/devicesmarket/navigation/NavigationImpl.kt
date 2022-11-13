package com.example.devicesmarket.navigation

import android.app.Activity
import android.content.Intent
import com.example.core.navigation.Navigation
import com.example.devicesmarket.main_market.MainActivity
import com.example.mycart.MyCartActivity
import com.example.productdetails.ProductDetailsActivity
import javax.inject.Inject

class NavigationImpl @Inject constructor() : Navigation {

    override fun toMainActivity(currentActivity: Activity) {
        val myIntent = Intent(currentActivity, MainActivity::class.java)
        currentActivity.startActivity(myIntent)
        currentActivity.finish()
    }

    override fun toMyCartActivity(currentActivity: Activity) {
        val myIntent = Intent(currentActivity, MyCartActivity::class.java)
        currentActivity.startActivity(myIntent)
        currentActivity.finish()
    }

    override fun toProductDetailsActivity(currentActivity: Activity) {
        val myIntent = Intent(currentActivity, ProductDetailsActivity::class.java)
        currentActivity.startActivity(myIntent)
        currentActivity.finish()
    }
}