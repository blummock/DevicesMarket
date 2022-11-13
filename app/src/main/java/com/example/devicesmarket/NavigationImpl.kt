package com.example.devicesmarket

import android.app.Activity
import android.content.Intent
import com.example.core.navigation.Navigation
import com.example.mycart.MyCartActivity
import com.example.productdetails.ProductDetailsActivity

class NavigationImpl(): Navigation {

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