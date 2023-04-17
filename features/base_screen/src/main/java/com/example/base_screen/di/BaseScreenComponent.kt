package com.example.base_screen.di

import com.example.base_screen.ui.BaseScreenFragment
import com.example.core.di.AbstractActivityComponent
import dagger.Component

@Component(
    dependencies = [AbstractActivityComponent::class],
    modules = [BaseScreenViewModelModule::class, ]
)
interface BaseScreenComponent {
    fun inject(fragment: BaseScreenFragment)
}
