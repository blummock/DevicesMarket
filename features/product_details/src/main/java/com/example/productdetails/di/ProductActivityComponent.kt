package com.example.productdetails.di

import com.example.core.di.AbstractAppComponent
import com.example.productdetails.di.ProductDetailsViewModelModule
import com.example.productdetails.ui.ProductDetailsActivity
import dagger.Component

@Component(dependencies = [AbstractAppComponent::class], modules = [ProductDetailsViewModelModule::class])
interface ProductActivityComponent {
    fun inject(activity: ProductDetailsActivity)
}