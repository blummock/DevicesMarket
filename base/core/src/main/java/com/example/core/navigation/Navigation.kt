package com.example.core.navigation

import android.app.Activity

interface Navigation {

    fun toMainActivity(currentActivity: Activity)

    fun toMyCartActivity(currentActivity: Activity)

    fun toProductDetailsActivity(currentActivity: Activity)
}