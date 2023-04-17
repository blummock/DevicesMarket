package com.example.base_screen.di

import com.example.base_screen.ui.BaseScreenViewModel
import com.example.core.di.ViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
object BaseScreenViewModelModule {

    @Provides
    fun provideViewFactory(provider: Provider<BaseScreenViewModel>): ViewModelFactory = ViewModelFactory(provider)
}