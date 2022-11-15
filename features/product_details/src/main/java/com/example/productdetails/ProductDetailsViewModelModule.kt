package com.example.productdetails

import com.example.core.di.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class ProductDetailsViewModelModule {

    @Provides
    fun provideViewFactory(provider: Provider<ProductDetailsViewModel>): ViewModelFactory = ViewModelFactory(provider)
}