package com.example.mycart.di

import com.example.core.di.AbstractActivityComponent
import com.example.mycart.ui.MyCartActivity
import dagger.Component

@Component(
    dependencies = [AbstractActivityComponent::class],
    modules = [MyCartViewModelModule::class]
)
interface MyCartActivityComponent {
    fun inject(activity: MyCartActivity)
}