package com.example.mycart.di

import com.example.core.di.ViewModelFactory
import com.example.mycart.ui.MyCartViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class MyCartViewModelModule {

    @Provides
    fun provideViewFactory(provider: Provider<MyCartViewModel>): ViewModelFactory = ViewModelFactory(provider)
}