package com.example.network.repository

import com.example.core.repo.AbstractRepositoryComponent
import com.example.network.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, RepositoryModule::class])
@Singleton
interface RepositoryComponent : AbstractRepositoryComponent {
}