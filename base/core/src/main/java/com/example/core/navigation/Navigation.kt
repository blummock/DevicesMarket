package com.example.core.navigation

import android.app.Activity
import android.os.Bundle

interface Navigation {

    fun toBaseFragment(bundle: Bundle?)

    fun toMainActivity(currentActivity: Activity)

    fun toMyCartActivity(currentActivity: Activity)

    fun toProductDetailsActivity(currentActivity: Activity, bundle: Bundle)
}