package com.example.mycart

import com.example.core.ActivityScope
import com.example.core.di.AbstractAppComponent
import dagger.Component

@ActivityScope
@Component(dependencies = [AbstractAppComponent::class])
interface MyCartActivityComponent {
    fun inject(activity: MyCartActivity)
}