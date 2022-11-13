package com.example.devicesmarket

import com.example.core.di.AbstractAppComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NavigationModule::class])
interface AppComponent : AbstractAppComponent {

}