package com.example.productdetails.di

import com.example.core.di.ViewModelFactory
import com.example.productdetails.ui.ProductDetailsViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class ProductDetailsViewModelModule {

    @Provides
    fun provideViewFactory(provider: Provider<ProductDetailsViewModel>): ViewModelFactory = ViewModelFactory(provider)
}