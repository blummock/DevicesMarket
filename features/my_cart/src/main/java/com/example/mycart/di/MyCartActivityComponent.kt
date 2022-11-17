package com.example.mycart.di

import com.example.core.di.AbstractAppComponent
import com.example.mycart.ui.MyCartActivity
import dagger.Component

@Component(dependencies = [AbstractAppComponent::class], modules = [MyCartViewModelModule::class])
interface MyCartActivityComponent {
    fun inject(activity: MyCartActivity)
}