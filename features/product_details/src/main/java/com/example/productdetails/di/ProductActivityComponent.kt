package com.example.productdetails.di

import com.example.core.di.AbstractActivityComponent
import com.example.productdetails.ui.ProductDetailsActivity
import dagger.Component

@Component(dependencies = [AbstractActivityComponent::class], modules = [ProductDetailsViewModelModule::class])
interface ProductActivityComponent {
    fun inject(activity: ProductDetailsActivity)
}