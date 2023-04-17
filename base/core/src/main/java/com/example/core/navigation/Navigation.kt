package com.example.core.navigation

import android.os.Bundle

interface Navigation {

    fun back()

    fun init()

    fun toBaseFragment(bundle: Bundle?)

    fun toMyCartFragment(bundle: Bundle?)

    fun toProductDetailsFragment(bundle: Bundle?)
}