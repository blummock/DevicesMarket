package com.example.mycart

import com.example.core.di.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class MyCartViewModelModule {

    @Provides
    fun provideViewFactory(provider: Provider<MyCartViewModel>): ViewModelFactory = ViewModelFactory(provider)
}