package com.example.devicesmarket.entry_activity.di

import androidx.fragment.app.FragmentManager
import com.example.core.di.AbstractActivityComponent
import com.example.devicesmarket.entry_activity.ui.MainActivity
import com.example.devicesmarket.navigation.NavigationModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    dependencies = [AppComponent::class],
    modules = [NavigationModule::class]
)
@Singleton
interface MainActivityComponent : AbstractActivityComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun fragmentManager(fragmentManager: FragmentManager): Builder
        fun appComponent(appComponent: AppComponent): Builder
        fun build(): MainActivityComponent
    }

    fun inject(activity: MainActivity)
}
