package com.example.mycart

import com.example.core.di.AbstractAppComponent
import dagger.Component

@Component(dependencies = [AbstractAppComponent::class], modules = [MyCartViewModelModule::class])
interface MyCartActivityComponent {
    fun inject(activity: MyCartActivity)
}