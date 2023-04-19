package com.example.core.di

interface AbstractActivity {

    fun getComponent(): AbstractActivityComponent

    fun fragmentIsReady()
}