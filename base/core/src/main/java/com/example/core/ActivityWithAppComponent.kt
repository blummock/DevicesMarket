package com.example.core

import androidx.appcompat.app.AppCompatActivity

open class ActivityWithAppComponent : AppCompatActivity() {

    protected val appComponent by lazy {
        (application as AbstractApp).getAppComponent()
    }
}