package com.example.mycart.di

import com.example.core.di.AbstractActivityComponent
import com.example.mycart.ui.MyCartFragment
import dagger.Component

@Component(
    dependencies = [AbstractActivityComponent::class],
    modules = [MyCartViewModelModule::class]
)
interface MyCartComponent {
    fun inject(fragment: MyCartFragment)
}