package com.example.core.di

import com.example.core.di.AbstractAppComponent

interface AbstractApp {

    fun getAppComponent(): AbstractAppComponent
}