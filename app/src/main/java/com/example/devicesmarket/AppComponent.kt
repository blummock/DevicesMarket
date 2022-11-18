package com.example.devicesmarket

import com.example.core.di.AbstractAppComponent
import com.example.core.repo.AbstractRepositoryComponent
import com.example.devicesmarket.navigation.NavigationModule
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [AbstractRepositoryComponent::class],
    modules = [NavigationModule::class]
)
@Singleton
interface AppComponent : AbstractAppComponent {
}