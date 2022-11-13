package com.example.core.navigation

import androidx.appcompat.app.AppCompatActivity

open class BackToMainActivity : AppCompatActivity() {

    protected fun toMainActivity() {
        (application as AppNavigation).getNavigation().toMainActivity(this)
    }

    override fun onBackPressed() {
        toMainActivity()
    }
}