package com.example.productdetails

import com.example.core.di.AbstractAppComponent
import dagger.Component

@Component(dependencies = [AbstractAppComponent::class])
interface ProductActivityComponent {
    fun inject(activity: ProductDetailsActivity)
}