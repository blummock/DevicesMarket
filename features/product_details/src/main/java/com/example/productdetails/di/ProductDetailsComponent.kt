package com.example.productdetails.di

import com.example.core.di.AbstractActivityComponent
import com.example.productdetails.ui.ProductDetailsFragment
import dagger.Component

@Component(
    dependencies = [AbstractActivityComponent::class],
    modules = [ProductDetailsViewModelModule::class]
)
interface ProductDetailsComponent {
    fun inject(fragment: ProductDetailsFragment)
}