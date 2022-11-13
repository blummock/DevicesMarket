package com.example.network

import com.example.core.repo.AbstractRepositoryComponent
import dagger.Component

@Component(modules = [NetworkModule::class, RepositoryModule::class])
interface RepositoryComponent : AbstractRepositoryComponent {
}